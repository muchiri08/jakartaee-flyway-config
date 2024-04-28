package com.muchiri.flywayjakartaee;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

/**
 * @author muchiri
 */
@ApplicationScoped
@ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Resource(lookup = "jdbc/flywayTestResource")
    private DataSource dataSource;

    public void onStartUp(@Observes @Initialized(ApplicationScoped.class) Object applicationContext) {
        var flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
