package com.batch.balance.domain.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TradeDao {

    @Resource(name = "sqlSessionTradeDb")
    private SqlSessionTemplate sqlSessionTradeDb;

//    public List<Order> selectTest(Map<String, String> data) {
//        return this.sqlSessionTradeDb.selectList("selectTest", data);
//    }


    //http://querydsl.com/

}
