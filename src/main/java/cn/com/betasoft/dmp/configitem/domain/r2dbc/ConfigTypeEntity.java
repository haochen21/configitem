package cn.com.betasoft.dmp.configitem.domain.r2dbc;

import cn.com.betasoft.dmp.configitem.domain.model.valueobjects.ConfigTypeMetaData;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table("config_type")
public class ConfigTypeEntity {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("display_name")
    private String displayName;

    @Column("icon")
    private String icon;

    @Column("meta_data")
    private ConfigTypeMetaData metaData;

    @Column("extra_meta_data")
    private Map<String, Object> extraMetaData;

    @Column("create_at")
    private LocalDateTime createAt;

    @Column("update_at")
    private LocalDateTime updateAt;

    @Column("version")
    private Long version;
}
