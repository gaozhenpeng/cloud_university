package com.chinasoft.teacher.service;

import com.chinasoft.teacher.common.ServerResponse;
import com.chinasoft.teacher.config.MessageConfig;
import com.chinasoft.teacher.data.entity.Teacher;
import com.chinasoft.teacher.data.model.TeacherQo;
import com.chinasoft.teacher.data.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Honkey on 2017/11/16 14:54.
 */
@Service
public class TeacherService {

    Logger logger= LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private MessageConfig messageConfig;

    private Pageable builderPage(int pageNum,int pageSize){
        return new PageRequest(pageNum,pageSize,new Sort(Sort.Direction.DESC,"createDate"));
    }

    public ServerResponse<Teacher> addOrUpdate(Teacher teacher){
        StringBuilder str=new StringBuilder();
        Boolean flag=true;
        if(teacher.getName()==null){
            str.append("讲师姓名 ");
            flag=false;
        }
        if(teacher.getIntroduce()==null){
            str.append("讲师简介 ");
            flag=false;
        }
        if(flag){
            try {
                if(teacher.getId()==null){
                    /**新增讲师信息*/
                    Teacher teachertemp = teacherRepository.save(teacher);
                    if(teachertemp!=null){
                        return ServerResponse.createBySuccess(messageConfig.getAddTeaSuccess(),teachertemp);
                    }
                    return ServerResponse.createByErrorMessage(messageConfig.getAddTeaFail());
                }
                /**修改讲师信息*/
                if(teacherRepository.findOne(teacher.getId())==null){
                    return ServerResponse.createByErrorMessage(messageConfig.getTeaIdNoExist());
                }
                Teacher teachertemp = teacherRepository.saveAndFlush(teacher);
                if(teachertemp!=null){
                    return ServerResponse.createBySuccess(messageConfig.getUpdateTeaSuccess(),teachertemp);
                }
                return ServerResponse.createByErrorMessage(messageConfig.getUpdateTeaFail());
            } catch (Exception e) {
                logger.debug(e.getMessage());
                return ServerResponse.createByErrorMessage(e.getMessage());
            }

        }
        return ServerResponse.createByErrorMessage(str+messageConfig.getNotNull());
    }

    public ServerResponse<Page<Teacher>> findAllOrLike(TeacherQo teacherQo){
        if(teacherQo==null){
            return ServerResponse.createByErrorMessage(messageConfig.getNotNull());
        }
        try {
            Page<Teacher> pageList=teacherRepository.findAllOrKeywordsLike(teacherQo.getName()==null ? "%" : "%"+teacherQo.getName()+"%",
                                                                            builderPage(teacherQo.getPageNum(),teacherQo.getPageSize()));
            if(pageList.getNumberOfElements()==0){
                return ServerResponse.createByErrorMessage("第"+(pageList.getNumber()+1)+messageConfig.getFindTeaFail());
            }
            return ServerResponse.createBySuccess("第"+(pageList.getNumber()+1)+messageConfig.getFindTeaSuccess(),pageList);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ServerResponse.createByErrorMessage(e.getMessage());
        }
    }

    public ServerResponse<Map<String,Integer>> delete(String idStr){
        if(idStr==null){
            return ServerResponse.createByErrorMessage(messageConfig.getNotNull());
        }
        try {
            String[] idArr=idStr.split(",");
            int count=0;
            for (String id : idArr) {
                teacherRepository.delete(id);
                count++;
            }
            Map<String,Integer> map=new HashMap<>();
            map.put("count",count);
            return ServerResponse.createBySuccess(messageConfig.getDeleteTeaSuccess(),map);
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ServerResponse.createByErrorMessage(e.getMessage());
        }
    }

}
