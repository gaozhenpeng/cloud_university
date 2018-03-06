package com.chinasoft.course.repository;

import com.chinasoft.course.data.CourseClass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VerRan.Liu on 2017/11/14.
 */
public interface CourseClassRepository extends JpaRepository<CourseClass,Long> {
}
