package cn.com.betasoft.dmp.configitem.application.internal.queryservices;

import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigType;
import cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc.ConfigTypeEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ConfigTypeQueryService {

    final ConfigTypeEntityRepository configTypeEntityRepository;

    public Mono<ConfigType> findByName(String name) {
        return configTypeEntityRepository.findByName(name)
                .map(configTypeEntity -> ConfigType.covertFromEntity(configTypeEntity));
    }
}