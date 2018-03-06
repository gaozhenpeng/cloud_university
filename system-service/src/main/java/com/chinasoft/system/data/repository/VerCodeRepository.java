package com.chinasoft.system.data.repository;

import com.chinasoft.system.data.entity.VerCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangyan on 2017/10/25.
 */
@Repository
public interface VerCodeRepository extends JpaRepository<VerCode,Long> {
    @Query(value = "select * from vercode v where v.endpoint = ?1 and v.type = ?2 order by v.createdate desc limit 1",nativeQuery=true)
    VerCode findvercodeByEndpointAndCreatedateAndType(@Param("endpoint") String endpoint, @Param("type") String type);
}
