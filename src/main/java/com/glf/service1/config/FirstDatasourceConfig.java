package com.glf.service1.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author glfadd
 */
@Configuration
@MapperScan(basePackages = "com.glf.service1.firstMapper", sqlSessionFactoryRef = "firstSqlSessionFactoryRef")
public class FirstDatasourceConfig {
    @Primary
    @Bean(name = "firstDatasource")
    @ConfigurationProperties("spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "firstSqlSessionFactoryRef")
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDatasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:firstMapper/*.xml")
        );
        return sessionFactoryBean.getObject();
    }
}
