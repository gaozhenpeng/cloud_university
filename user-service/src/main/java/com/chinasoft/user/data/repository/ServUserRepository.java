package com.chinasoft.user.data.repository;

import com.chinasoft.user.data.entity.ServUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
public interface ServUserRepository extends JpaRepository<ServUser,Long> {
    Page<ServUser> findByNameLike(String s, Pageable pageable);
}
