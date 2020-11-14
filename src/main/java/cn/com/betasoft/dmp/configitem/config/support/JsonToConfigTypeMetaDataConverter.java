package cn.com.betasoft.dmp.configitem.config.support;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.ConfigTypeMetaData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.io.IOException;

@Slf4j
@ReadingConverter
@AllArgsConstructor
public class JsonToConfigTypeMetaDataConverter implements Converter<Json, ConfigTypeMetaData> {

    private final ObjectMapper objectMapper;

    @Override
    public ConfigTypeMetaData convert(Json json) {
        try {
            return objectMapper.readValue(json.asString(), ConfigTypeMetaData.class);
        } catch (IOException e) {
            log.error("Problem while parsing JSON: {}", json, e);
            return null;
        }
    }

}
