package com.chinasoft.obs.data.repository;

import com.chinasoft.obs.data.entity.ObjectBulk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VerRan.Liu on 2017/11/16.
 */
public interface ObjectBulkRepository extends JpaRepository<ObjectBulk,Long>{
    Page<ObjectBulk> findByObjectNameLike(String s, Pageable pageable);

    Page<ObjectBulk> findByOwnerLike(String s, Pageable pageable);
}
