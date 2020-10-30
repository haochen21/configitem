package cn.com.betasoft.dmp.configitem.application.internal.commandservices;

import cn.com.betasoft.dmp.configitem.domain.jdbc.ConfigItemEntity;
import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigItem;
import cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc.ConfigItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@Slf4j
public class ConfigItemCommandService {

    ConfigItemRepository configItemRepository;

    public ConfigItemCommandService(ConfigItemRepository configItemRepository) {
        this.configItemRepository = configItemRepository;
    }

    @Transactional
    public Mono<ConfigItem> saveConfigItem(ConfigItem configItem) {
        ConfigItemEntity entity = new ConfigItemEntity();
        entity.setName(configItem.getName());
        entity.setDisplayName(configItem.getDisplayName());
        entity.setDescription(configItem.getDescription());
        entity.setIcon(configItem.getIcon());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());

        return configItemRepository.save(entity)
                .map(configItemEntity -> {
                    ConfigItem ci = new ConfigItem();
                    ci.setId(configItemEntity.getId());
                    ci.setName(configItemEntity.getName());
                    ci.setDisplayName(configItemEntity.getDisplayName());
                    ci.setDescription(configItemEntity.getDescription());
                    ci.setIcon(configItemEntity.getIcon());
                    ci.setCreateTime(new Date());
                    ci.setUpdateTime(new Date());
                    return ci;
                });
    }
}
