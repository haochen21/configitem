package cn.com.betasoft.dmp.configitem.domain.jdbc;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table("config_item")
public class ConfigItemEntity {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private String description;

    private String displayName;

    private String icon;

    private Date createTime;

    private Date updateTime;
}
