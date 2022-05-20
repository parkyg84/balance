package com.batch.balance.job;

import com.batch.balance.domain.dto.Order;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TradeConfiguration {

    //https://velog.io/@neity16/Spring-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8-8-Primary-Qualifier
    private final int pageSize = 10;

    @Bean(name = "tradeDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.trade.datasource")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sqlSessionTradeDbFactory")
    public SqlSessionFactory sqlSessionProductFactory(@Qualifier("tradeDatasource") DataSource datasorce, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(datasorce);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/trade/*.xml"));
        return factoryBean.getObject();
    }

    @Primary
    @Bean(name = "sqlSessionTradeDb")
    public SqlSessionTemplate sqlSessionProduct(@Qualifier("sqlSessionTradeDbFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }

    @Primary
    @Bean(name = "tradeTX")
    public PlatformTransactionManager ProductTransactionManager(@Qualifier("tradeDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name ="myBatisPagingItemReader")
    @StepScope
    public MyBatisPagingItemReader<Order> tradeDbRead(@Qualifier("sqlSessionTradeDbFactory") SqlSessionFactory sqlSessionFactory) {

        MyBatisPagingItemReader<Order> myBatisPagingItemReader = new MyBatisPagingItemReader<Order>();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("_page", myBatisPagingItemReader.getPage());
        //parameters.put("_pageSize", myBatisPagingItemReader.getPageSize());
        parameters.put("_pageSize", pageSize);

        myBatisPagingItemReader.setQueryId("selectTest2");
        myBatisPagingItemReader.setSqlSessionFactory(sqlSessionFactory);
        myBatisPagingItemReader.setParameterValues(parameters);
        return myBatisPagingItemReader;
    }

    //https://techblog.woowahan.com/2662/
}
