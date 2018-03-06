package com.chinasoft.user.data.repository;

import com.chinasoft.user.data.entity.ServUserCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
public interface ServUserCourseRepository extends JpaRepository<ServUserCourse,Long> {

    Page<ServUserCourse> findByServUserId(Long id, Pageable pageable);
}
