package cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc;

import cn.com.betasoft.dmp.configitem.domain.r2dbc.ConfigTypeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ConfigTypeEntityRepository {

    final DatabaseClient databaseClient;

    final TransactionalOperator operator;

    public Mono<ConfigTypeEntity> save(ConfigTypeEntity typeEntity) {
        return this.databaseClient
                .execute("INSERT INTO config_type (name, description, display_name, icon, meta_data, extra_meta_data, create_at, update_at, version) values(:name, :description, :displayName, :icon, :metaData, :extraMetaData, :createAt, :updateAt, :version)")
                .filter((statement, executeFunction) -> statement.returnGeneratedValues("id").execute())
                .bind("name", typeEntity.getName())
                .bind("description", typeEntity.getDescription())
                .bind("displayName", typeEntity.getDisplayName())
                .bind("icon", typeEntity.getIcon())
                .bind("metaData", typeEntity.getMetaData())
                .bind("extraMetaData", typeEntity.getExtraMetaData())
                .bind("createAt", typeEntity.getCreateAt())
                .bind("updateAt", typeEntity.getUpdateAt())
                .bind("version", typeEntity.getVersion())
                .as(ConfigTypeEntity.class)
                .fetch()
                .first();
    }

    public Mono<ConfigTypeEntity> findByName(String name) {
        return this.databaseClient.execute("SELECT * FROM config_type WHERE name = :name")
                .bind("name", name)
                .as(ConfigTypeEntity.class)
                .fetch().one();
    }
}
