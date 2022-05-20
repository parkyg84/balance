package com.batch.balance.domain.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AdminDao {

    @Resource(name = "sqlSessionAdminDb")
    private SqlSessionTemplate sqlSessionAdminDb;

//    public List<Order> selectTest(Map<String, String> data) {
//        return this.sqlSessionAdminDb.selectList("selectTest", data);
//    }
    
}
