package com.develop.persistence.mapper;

import com.develop.domain.WebDomain;
import com.develop.persistence.entity.WebEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WebMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "active", target = "active")
    })
    WebDomain toDomain(WebEntity entity);
    List<WebDomain> toDomains(List<WebEntity> entities);

    @InheritInverseConfiguration
    WebEntity toEntity(WebDomain domain);
}
