package lk.nie.planningDepOauthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import javax.sql.DataSource;

@EnableAuthorizationServer
@SpringBootApplication
@ComponentScan(basePackages = {"lk.nie.planningDepOauthService.*"})
@EntityScan(basePackages = {"dep.planning.core.*"})
@EnableJpaRepositories(basePackages = {"lk.nie.planningDepOauthService.*"})
public class PlanningDepOauthServiceApplication {
    @Autowired
    DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(PlanningDepOauthServiceApplication.class, args);
    }
}
