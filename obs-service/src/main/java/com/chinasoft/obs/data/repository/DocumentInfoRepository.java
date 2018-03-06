package com.chinasoft.obs.data.repository;

import com.chinasoft.obs.data.entity.DocumentInfo;
import com.chinasoft.obs.data.entity.ObjectBulk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by VerRan.Liu on 2017/12/7.
 */
@Repository
public interface DocumentInfoRepository extends JpaRepository<DocumentInfo,Long>{
    Page<DocumentInfo> findByDocName(String s, Pageable pageable);
}
