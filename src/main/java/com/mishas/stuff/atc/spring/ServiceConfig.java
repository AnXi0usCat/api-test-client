package com.mishas.stuff.atc.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.mishas.stuff.atc.service"})
public class ServiceConfig {

}
