package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String DB_WORLD_URL;
    @Value("${DB_WORLD_USER}")
    private String DB_WORLD_USER;
    @Value("${DB_WORLD_PASS}")
    private String DB_WORLD_PASS;
    @Value("${DB_WORLD_DRIVER}")
    private String DB_WORLD_DRIVER;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_WORLD_URL);
        config.setUsername(DB_WORLD_USER);
        config.setPassword(DB_WORLD_PASS);
        config.setDriverClassName(DB_WORLD_DRIVER);

        // configuracion de HikariCP
        config.setMaximumPoolSize(30); // numero maximo de conexiones en el pool
        config.setMinimumIdle(4); // numero minimo de conexiones que deben mantenerse inactivas en el pool
        config.setIdleTimeout(240000); // 4 minutos, tiempo en milisegundos despues del cual una conexion inactiva puede ser eliminada
        config.setConnectionTimeout(45000); // 45 segundos, tiempo en milisegundos que el pool espera para obtener una conexion antes de lanzar una excepcion

        return new HikariDataSource(config);
    }
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatFactoryCustomizer(HikariDataSource hikariDataSource) {
        return factory -> factory.addContextCustomizers(context -> {
            try {
                Context initCtx = new InitialContext();
                initCtx.bind("java:comp/env/jdbc/MySakila", hikariDataSource);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        });
    }

}
