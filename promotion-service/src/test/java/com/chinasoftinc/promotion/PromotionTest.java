//package com.chinasoftinc.promotion;
//
//import com.chinasoftinc.promotion.data.po.Promotion;
//import com.chinasoftinc.promotion.data.repository.PromotionRepository;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * Created by VerRan.Liu on 2017/12/21.
// */
//@DataJpaTest
//@RunWith(SpringRunner.class)
//public class PromotionTest {
//    @Autowired
//    PromotionRepository promotionRepository;
//    @Test
//    public void test(){
//        Promotion promotion=new Promotion();
//        promotion.setPromoteDesc("aa");
//        promotion.setPromoteName("BB");
//        promotion.setPromoteType("AA");
//        promotionRepository.save(promotion);
//        Assert.assertEquals(1,promotionRepository.findAll().size());
//    }
//}
