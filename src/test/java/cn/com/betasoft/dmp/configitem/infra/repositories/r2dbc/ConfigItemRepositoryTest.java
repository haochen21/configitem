package cn.com.betasoft.dmp.configitem.infra.repositories.r2dbc;

import cn.com.betasoft.dmp.configitem.domain.jdbc.ConfigItemEntity;
import cn.com.betasoft.dmp.configitem.domain.model.aggregates.ConfigItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

import java.util.Date;

@SpringBootTest
public class ConfigItemRepositoryTest {

    @Autowired
    ConfigItemRepository configItemRepository;

    @Test
    public void testCreate() {
        ConfigItemEntity ci = new ConfigItemEntity();
        ci.setName("Windows");
        ci.setDisplayName("window操作系统");
        ci.setDescription("windows");
        ci.setIcon("win.png");
        ci.setCreateTime(new Date());
        ci.setUpdateTime(new Date());

        configItemRepository.save(ci)
                .as(StepVerifier::create)
                .expectNextCount(1)
                .verifyComplete();
    }
}
