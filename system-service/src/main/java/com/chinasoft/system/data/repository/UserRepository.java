package com.chinasoft.system.data.repository;

import com.chinasoft.system.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select t from User t where t.name like :name")
    Page<User> findByName(@Param("name") String name, Pageable pageRequest);

    User findByMobilePhone(@Param("mobile_Phone") String mobilePhone);

    User findByLoginName(@Param("login_Name") String loginName);

    @Query(value = "select t from User t where t.count =?1")
    List<User> findUserByCount(@Param("count") int count);

    User deleteByUserId(String userId);

    User findUserByUserId(String userId);

    User findByLoginNameOrMobilePhone(String loginName, String mobilePhone);
}
