package com.chinasoft.course.repository;

import com.chinasoft.course.data.CourseClass;
import com.chinasoft.course.repository.CourseClassRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by VerRan.Liu on 2017/11/14.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class CourseTest {

    @Autowired
    CourseClassRepository courseClassRepository;

    @Test
    public void testAdd(){
        CourseClass courseClass =new CourseClass();
        courseClass.setClassCode("1");
        courseClass.setClassName("编程语言");
        courseClassRepository.save(courseClass);
        Assert.assertEquals(1,courseClassRepository.findAll().size());
    }
}
