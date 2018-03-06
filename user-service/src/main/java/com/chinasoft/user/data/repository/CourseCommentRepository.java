package com.chinasoft.user.data.repository;

import com.chinasoft.user.data.entity.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by VerRan.Liu on 2017/11/17.
 */
public interface CourseCommentRepository extends JpaRepository<CourseComment,Long> {
}
