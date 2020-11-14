package cn.com.betasoft.dmp.configitem.config;

import cn.com.betasoft.dmp.configitem.config.support.ConfigTypeMetaDataToJsonConverter;
import cn.com.betasoft.dmp.configitem.config.support.JsonToConfigTypeMetaDataConverter;
import cn.com.betasoft.dmp.configitem.config.support.JsonToMapConverter;
import cn.com.betasoft.dmp.configitem.config.support.MapToJsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.connectionfactory.R2dbcTransactionManager;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableR2dbcRepositories
@EnableTransactionManagement
@RequiredArgsConstructor
public class PostgresConfiguration extends AbstractR2dbcConfiguration {

    @Value("${spring.r2dbc.url}")
    private String url;

    @Value("${spring.r2dbc.username}")
    private String username;

    @Value("${spring.r2dbc.password}")
    private String password;

    final ObjectMapper objectMapper;

    @Bean
    @Override
    public ConnectionFactory connectionFactory() {
        Map<String, String> options = new HashMap<>();
        options.put("lock_timeout", "10s");

        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(RegexWizard.getJdbcHost(url))
                        .port(RegexWizard.getJdbcPort(url))
                        .username(username)
                        .password(password)
                        .database(RegexWizard.getDbName(url))
                        .options(options)
                        .build());
    }

    @Bean
    ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }

    @Bean
    @Override
    public R2dbcCustomConversions r2dbcCustomConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new ConfigTypeMetaDataToJsonConverter(objectMapper));
        converters.add(new JsonToConfigTypeMetaDataConverter(objectMapper));
        converters.add(new JsonToMapConverter(objectMapper));
        converters.add(new MapToJsonConverter(objectMapper));
        return new R2dbcCustomConversions(getStoreConversions(), converters);
    }
}
