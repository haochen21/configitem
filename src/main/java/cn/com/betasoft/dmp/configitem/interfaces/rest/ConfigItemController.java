package cn.com.betasoft.dmp.configitem.interfaces.rest;

import cn.com.betasoft.dmp.configitem.application.internal.commandservices.ConfigItemCommandService;
import cn.com.betasoft.dmp.configitem.application.internal.queryservices.ConfigItemQueryService;
import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/configItem")
public class ConfigItemController {

    private ConfigItemCommandService configItemCommandService;

    private ConfigItemQueryService configItemQueryService;

    public ConfigItemController(ConfigItemCommandService configItemCommandService,
                                ConfigItemQueryService configItemQueryService) {
        this.configItemCommandService = configItemCommandService;
        this.configItemQueryService = configItemQueryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ConfigItem> create(@RequestBody ConfigItem configItem) {
        return configItemCommandService.saveConfigItem(configItem);
    }
}
