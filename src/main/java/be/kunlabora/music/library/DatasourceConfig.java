package be.kunlabora.music.library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${DB_HOST}")
    private String host;

    @Value("${DB_NAME}")
    private String dbName;

    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:aws-dsql:postgresql://" + host + "/" + dbName + "?ssl=true");
        ds.setUsername("admin");
        ds.setMaxLifetime(1500000);
        return ds;
    }
}