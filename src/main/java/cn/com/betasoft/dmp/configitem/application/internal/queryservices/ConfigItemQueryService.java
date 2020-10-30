package cn.com.betasoft.dmp.configitem.application.internal.queryservices;

import cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc.ConfigItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfigItemQueryService {

    ConfigItemRepository configItemRepository;

    public ConfigItemQueryService(ConfigItemRepository configItemRepository) {
        this.configItemRepository = configItemRepository;
    }
}
