// 20210214

package com.kaplan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



@Configuration
@ComponentScan({ "com.kaplan" })
@PropertySource("application.properties")
public class AppConfig {


	
}
