package cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.ConfigTypeMetaData;
import cn.com.betasoft.dmp.configitem.domain.r2dbc.ConfigTypeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@SpringBootTest
public class ConfigTypeRepositoryTest {

    @Autowired
    ConfigTypeEntityRepository configTypeEntityRepository;

    // select * from config_type where meta_data->'user' ?| array['Admin', 'chenhao']

    @Test
    public void testCreate() {
        ConfigTypeEntity type = new ConfigTypeEntity();
        type.setName("Windows-1");
        type.setDisplayName("window操作系统");
        type.setDescription("windows");
        type.setIcon("win.png");

        ConfigTypeMetaData configTypeMetaData = new ConfigTypeMetaData();
        configTypeMetaData.setDataSource("BTPM");
        configTypeMetaData.setTargets(Arrays.asList("BTPM", "AiOps"));
        configTypeMetaData.setUsers(Arrays.asList("Admin", "chenhao", "xuhanhan"));
        type.setMetaData(configTypeMetaData);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ObjectNode rootNode = objectMapper.createObjectNode();

            ObjectNode dataSourceNode = objectMapper.createObjectNode();
            dataSourceNode.put("name", "BTPM");
            dataSourceNode.put("description", "监控平台");
            rootNode.set("dataSource", dataSourceNode);

            ArrayNode useTargetNode = objectMapper.createArrayNode();
            useTargetNode.add("BTPM");
            useTargetNode.add("AiOps");
            rootNode.set("useTarget", useTargetNode);

            ArrayNode userNode = objectMapper.createArrayNode();
            userNode.add("Admin");
            userNode.add("chenhao");
            userNode.add("xuhanhan");
            rootNode.set("user", userNode);

            String metaJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            Map<String, Object> extraMetaData = objectMapper.readValue(metaJson, Map.class);
            type.setExtraMetaData(extraMetaData);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        type.setCreateAt(LocalDateTime.now());
        type.setUpdateAt(LocalDateTime.now());
        type.setVersion(0L);

        configTypeEntityRepository.save(type)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }

    //@Test
    public void testFindByName() {
        configTypeEntityRepository.findByName("Windows")
                .as(StepVerifier::create)
                .expectNextMatches(configTypeEntity -> {
                    log.info("configType is: {}.", configTypeEntity);
                    return configTypeEntity.getName().equals("Windows");
                })
                .verifyComplete();
    }
}
