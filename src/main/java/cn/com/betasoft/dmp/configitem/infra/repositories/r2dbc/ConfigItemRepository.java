package cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc;

import cn.com.betasoft.dmp.configitem.domain.jdbc.ConfigItemEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ConfigItemRepository extends ReactiveCrudRepository<ConfigItemEntity, Long> {

    Flux<ConfigItemEntity> findConfigItemEntityByNameContainingIgnoreCase(String name);
}
