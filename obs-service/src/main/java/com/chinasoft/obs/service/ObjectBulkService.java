package com.chinasoft.obs.service;

import com.chinasoft.obs.data.entity.DocumentInfo;
import com.chinasoft.obs.data.entity.ObjectBulk;
import com.chinasoft.obs.data.repository.DocumentInfoRepository;
import com.chinasoft.obs.data.repository.ObjectBulkRepository;
import com.chinasoft.obs.vo.DocumentVO;
import com.chinasoft.obs.vo.ObjectBulkVO;
import com.chinasoft.obs.vo.ResponseVO;
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
 * Created by VerRan.Liu on 2017/11/16.
 */
@Service
public class ObjectBulkService {
    @Autowired
    private ObjectBulkRepository repository;


    /**
     * 服务路由信息查询，支持根据 对象名称，和对象归属者 模糊查询
     * @param  vo
     * @return ResponseVO
     * **/
    public ResponseVO query(ObjectBulkVO vo) {
        ResponseVO responseVO =new ResponseVO();
        Page<ObjectBulk> page = null;
        Pageable pageable = new PageRequest(vo.getPageNum(), vo.getPageSize(),
                new Sort(Sort.Direction.ASC, "id"));
        if(!StringUtils.isEmpty(vo.getObjectName())){
            page= repository.findByObjectNameLike("%"+vo.getObjectName()+"%",pageable);
        }else if(!StringUtils.isEmpty(vo.getOwner())){
            page= repository.findByOwnerLike("%"+vo.getOwner()+"%",pageable);
        } else{//如果所有条件为空，则返回全部
            page = repository.findAll(pageable);
        }
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        responseVO.setOutput(page);
        return responseVO;
    }


    /**
     * 服务路由信息添加/修改
     * @param  po
     * @return ResponseVO
     * **/
    public ResponseVO save(ObjectBulk po) throws Exception {
        ResponseVO responseVO =new ResponseVO();
        responseVO.setOutput(repository.save(po));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }



    /**
     * 服务路由信息删除
     * @param  id 当删除多个时id已逗号分隔，如1,2,3
     * @return ResponseVO
     * **/
    public ResponseVO delete(String id) throws Exception{
        ResponseVO responseVO =new ResponseVO();
        List<ObjectBulk> dels=new ArrayList();
        String[] idArray=id.split(",");
        for(int i=0;i<idArray.length;i++){
            String idi=  idArray[i];
            ObjectBulk serviceRouter=new ObjectBulk();
            serviceRouter.setId(new Long(idi));
            dels.add(serviceRouter);
        }
        repository.deleteInBatch(dels);
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }

    @Autowired
    private DocumentInfoRepository documentInfoRepository;
    public ResponseVO docSave(DocumentInfo documentInfo) {
        ResponseVO responseVO =new ResponseVO();
        responseVO.setOutput(documentInfoRepository.save(documentInfo));
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        return responseVO;
    }

    public ResponseVO docQuery(DocumentVO documentVO) {
        ResponseVO responseVO =new ResponseVO();
        Page<DocumentInfo> page = null;
        Pageable pageable = new PageRequest(documentVO.getPageNum(), documentVO.getPageSize(),
                new Sort(Sort.Direction.ASC, "id"));
        if(!StringUtils.isEmpty(documentVO.getDocName())){
            page= documentInfoRepository.findByDocName("%"+documentVO.getDocName()+"%",pageable);
        } else{//如果所有条件为空，则返回全部
            page = documentInfoRepository.findAll(pageable);
        }
        responseVO.setCode("1");
        responseVO.setMessage("成功");
        responseVO.setOutput(page);
        return responseVO;
    }
}
