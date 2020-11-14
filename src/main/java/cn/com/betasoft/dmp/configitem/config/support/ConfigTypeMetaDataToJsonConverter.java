package cn.com.betasoft.dmp.configitem.config.support;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.ConfigTypeMetaData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.r2dbc.postgresql.codec.Json;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

@Slf4j
@WritingConverter
@AllArgsConstructor
public class ConfigTypeMetaDataToJsonConverter implements Converter<ConfigTypeMetaData, Json> {

    private final ObjectMapper objectMapper;

    @Override
    public Json convert(ConfigTypeMetaData source) {
        try {
            return Json.of(objectMapper.writeValueAsString(source));
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing map to JSON: {}", source, e);
        }
        return Json.of("");
    }

}