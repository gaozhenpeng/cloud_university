package com.chinasoft.user.service;

import com.chinasoft.user.data.entity.CourseComment;
import com.chinasoft.user.data.entity.ServUser;
import com.chinasoft.user.data.entity.ServUserCourse;
import com.chinasoft.user.data.repository.CourseCommentRepository;
import com.chinasoft.user.data.repository.ServUserCourseRepository;
import com.chinasoft.user.data.repository.ServUserRepository;
import com.chinasoft.user.vo.ResponseVO;
import com.chinasoft.user.vo.ServUserCourseVO;
import com.chinasoft.user.vo.ServUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@Service
public class ServUserService {
    @Autowired
    ServUserRepository repository;
    @Autowired
    ServUserCourseRepository servUserCourseRepository;
    @Autowired
    CourseCommentRepository courseCommentRepository;

    /**
     *
     * 根据用户名称模糊查询用户列表信息
     *
     * **/
    public ResponseVO query(ServUserVO vo) {
        ResponseVO responseVO =new ResponseVO();
        Page<ServUser> page = null;
        Pageable pageable = new PageRequest(vo.getPageNum(), vo.getPageSize(),
                new Sort(Sort.Direction.ASC, "id"));
        if(!StringUtils.isEmpty(vo.getName())){
            page = repository.findByNameLike("%"+vo.getName()+"%",pageable);
        }
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        responseVO.setOutput(page);
        return responseVO;

    }

    /**
     * 用户信息添加/修改
     * @param  po
     * @return ResponseVO
     * **/
    public ResponseVO save(ServUser po) throws Exception {
        ResponseVO responseVO =new ResponseVO();
        responseVO.setOutput(repository.save(po));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }



    /**
     * 用户信息删除
     * @param  id 当删除多个时id已逗号分隔，如1,2,3
     * @return ResponseVO
     * **/
    public ResponseVO delete(String id) throws Exception{
        ResponseVO responseVO =new ResponseVO();
        List<ServUser> dels=new ArrayList();
        String[] idArray=id.split(",");
        for(int i=0;i<idArray.length;i++){
            String idi=  idArray[i];
            ServUser servUser=new ServUser();
            servUser.setId(new Long(idi));
            dels.add(servUser);
        }
        repository.deleteInBatch(dels);
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }

    /**
     * 用户选择收藏课程信息
     * @param  servUserCourse
     * @return ResponseVO
     * **/
    public ResponseVO selectCourse(ServUserCourse servUserCourse) {
        ResponseVO responseVO =new ResponseVO();
        responseVO.setOutput(servUserCourseRepository.save(servUserCourse));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }

    /**
     * 用户删除已选择或者收藏的课程信息
     * @param  id
     * @return ResponseVO
     * **/
    public ResponseVO deleteSelCourse(String id) {
        ResponseVO responseVO =new ResponseVO();
        servUserCourseRepository.delete(new Long(id));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }


    /**
     * 用户发布或者修改评论 针对课程的
     * @param  courseComment
     * @return ResponseVO
     * **/
    public ResponseVO publishComment(CourseComment courseComment) {
        ResponseVO responseVO =new ResponseVO();
        responseVO.setOutput(courseCommentRepository.save(courseComment));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }


    /**
     * 用户删除已发布的评论信息
     * @param  id
     * @return delVO
     * **/
    public ResponseVO deleteComment(String id) {
        ResponseVO responseVO =new ResponseVO();
         servUserCourseRepository.delete(new Long(id));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }

    /**
     *
     * 已选课程查询,根据用户ID
     *
     * */

    public ResponseVO selectCourseQuery(ServUserCourseVO vo) {
        ResponseVO responseVO =new ResponseVO();
        Page<ServUserCourse> page = null;
        Pageable pageable = new PageRequest(vo.getPageNum(), vo.getPageSize(),
                new Sort(Sort.Direction.ASC, "id"));
        if(!StringUtils.isEmpty(vo.getServUserId())){
            page = servUserCourseRepository.findByServUserId(new Long(vo.getServUserId()),pageable);
        }
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        responseVO.setOutput(page);
        return responseVO;
    }
}
