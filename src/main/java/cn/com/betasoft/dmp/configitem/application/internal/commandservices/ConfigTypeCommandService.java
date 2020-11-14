package cn.com.betasoft.dmp.configitem.application.internal.commandservices;

import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigType;
import cn.com.betasoft.dmp.configitem.domain.r2dbc.ConfigTypeEntity;
import cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc.ConfigTypeEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigTypeCommandService {

    final ConfigTypeEntityRepository typeEntityRepository;

    @Transactional
    public Mono<ConfigType> saveConfigItem(ConfigType type) {
        ConfigTypeEntity entity = new ConfigTypeEntity();
        entity.setName(type.getName());
        entity.setDisplayName(type.getDisplayName());
        entity.setDescription(type.getDescription());
        entity.setIcon(type.getIcon());
        entity.setCreateAt(LocalDateTime.now());
        entity.setUpdateAt(LocalDateTime.now());

        return typeEntityRepository.save(entity)
                .map(configTypeEntity -> ConfigType.covertFromEntity(configTypeEntity));
    }
}
