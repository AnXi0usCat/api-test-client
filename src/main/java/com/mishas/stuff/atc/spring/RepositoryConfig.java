package com.mishas.stuff.atc.spring;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(value = {"com.mishas.stuff.atc.persistence"})
@EntityScan(value = {"com.mishas.stuff.atc.persistence.model"})
@EnableJpaRepositories({"com.mishas.stuff.atc.persistence.dao"})
public class RepositoryConfig {

}
