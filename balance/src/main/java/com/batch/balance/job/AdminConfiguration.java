package com.batch.balance.job;

import com.batch.balance.domain.dto.Order;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


@Configuration
public class AdminConfiguration {


    @Bean(name="adminDatasource")
    @ConfigurationProperties(prefix = "spring.admin.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    //@Primary
    @Bean(name = "sqlSessionAdminDbFactory")
    public SqlSessionFactory sqlSessionProductFactory(@Qualifier("adminDatasource") DataSource datasorce, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasorce);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/admin/*.xml"));
        return factoryBean.getObject();
    }

    //@Primary
    @Bean(name = "sqlSessionAdminDb")
    public SqlSessionTemplate sqlSessionProduct(@Qualifier("sqlSessionAdminDbFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    //@Primary
    @Bean(name = "adminTX")
    public PlatformTransactionManager ProductTransactionManager(@Qualifier("adminDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }



    @Bean(name ="myBatisBatchItemWriter")
    @StepScope
    public MyBatisBatchItemWriter<Order> writer(@Qualifier("sqlSessionAdminDbFactory")SqlSessionFactory sqlSessionFactory){
        MyBatisBatchItemWriter<Order> myBatisBatchItemWriter = new MyBatisBatchItemWriter<Order>();
        myBatisBatchItemWriter.setSqlSessionFactory(sqlSessionFactory);
        myBatisBatchItemWriter.setStatementId("insertTest");
        return myBatisBatchItemWriter;
    }

}
