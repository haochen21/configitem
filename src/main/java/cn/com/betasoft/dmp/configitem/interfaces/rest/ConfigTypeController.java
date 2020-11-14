package cn.com.betasoft.dmp.configitem.interfaces.rest;

import cn.com.betasoft.dmp.configitem.application.internal.commandservices.ConfigTypeCommandService;
import cn.com.betasoft.dmp.configitem.application.internal.queryservices.ConfigTypeQueryService;
import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/configItem")
public class ConfigTypeController {

    final ConfigTypeCommandService configTypeCommandService;

    final ConfigTypeQueryService configTypeQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ConfigType> create(@RequestBody ConfigType configType) {
        return configTypeCommandService.saveConfigItem(configType);
    }
}
