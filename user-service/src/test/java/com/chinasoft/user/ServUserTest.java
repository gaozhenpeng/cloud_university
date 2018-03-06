//package com.chinasoft.user;
//
//import com.chinasoft.user.data.entity.CourseComment;
//import com.chinasoft.user.data.entity.ServUser;
//import com.chinasoft.user.data.entity.ServUserCourse;
//import com.chinasoft.user.data.repository.CourseCommentRepository;
//import com.chinasoft.user.data.repository.ServUserCourseRepository;
//import com.chinasoft.user.data.repository.ServUserRepository;
//import com.chinasoft.user.util.DateUtils;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Date;
//
///**
// * Created by VerRan.Liu on 2017/11/17.
// */
//@DataJpaTest
//@RunWith(SpringRunner.class)
//public class ServUserTest {
//
//    @Autowired
//    ServUserRepository servUserRepository ;
//    @Autowired
//    ServUserCourseRepository servUserCourseRepository ;
//    @Autowired
//    CourseCommentRepository courseCommentRepository;
//    @Test
//    public void add(){//用户
//
//        //1. 创建用户
//        ServUser servUser =new ServUser();
//        servUser.name="刘恒涛";
//        servUser.age="20";
//        servUser.vocation="架构师";
//        servUser.address="架构师";
//        servUser.sex="男";
//        servUser =servUserRepository.save(servUser);
//
//        //2. 用户选择课程
//        ServUserCourse servUserCourse =new ServUserCourse();
//        servUserCourse.courseId=1;
//        servUserCourse.courseName="java变成思想";
//        servUserCourse.servUserId=servUser.getId();
//        servUserCourse.createTime=new Date();
//        servUserCourse.learnLength=100;
//        servUserCourseRepository.save(servUserCourse);
//
//        servUserCourse.courseId=2;
//        servUserCourse.courseName="ECS";
//        servUserCourse.servUserId=servUser.getId();
//        servUserCourse.createTime=new Date();
//        servUserCourse.learnLength=0;
//        servUserCourseRepository.save(servUserCourse);
//
//        Page<ServUserCourse> page = null;
//        Pageable pageable = new PageRequest(1, 10,
//                new Sort(Sort.Direction.ASC, "id"));
//
//        Page<ServUserCourse> pp =
//                servUserCourseRepository.findByServUserId(servUser.getId(),pageable);
//        Assert.assertEquals(2,pp.getTotalElements());
//
//        //3. 用户针对课程的评论
//        CourseComment courseComment=new CourseComment();
//        courseComment.servUserId=servUser.getId();
//        courseComment.courseId=1;
//        courseComment.courseName="ECS";
//        courseComment.createTime= DateUtils.parseDateToStr(new Date(),DateUtils.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI);
//        courseComment.comment="不错的课程";
//        courseCommentRepository.save(courseComment);
//    }
//}
