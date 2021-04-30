package kz.iitu.lms.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("kz.iitu.lms")
@PropertySource("application.properties")
public class ProjectConfig {
}
