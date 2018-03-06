package com.chinasoft.teacher.data.repository;

import com.chinasoft.teacher.data.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Honkey on 2017/11/16 11:51.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,String> {

    @Query("select t from Teacher t where t.name like :keyWords")
    Page<Teacher> findAllOrKeywordsLike(@Param("keyWords") String keyWords, Pageable pageRequest);
}
