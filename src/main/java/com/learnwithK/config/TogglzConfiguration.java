package com.learnwithK.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.user.FeatureUser;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

import javax.sql.DataSource;

@Configuration
public class TogglzConfiguration {

    @Autowired
    private DataSource dataSource;


    @Bean
    public StateRepository stateRepository(){
        return new JDBCStateRepository(dataSource);
    }
 @Bean
    public UserProvider userProvider(){
        return new UserProvider(){
            @Override
            public FeatureUser getCurrentUser(){
                return new SimpleFeatureUser("admin", true);
            }
        };
 }


}
