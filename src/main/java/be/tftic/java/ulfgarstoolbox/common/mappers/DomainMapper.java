package be.tftic.java.ulfgarstoolbox.common.mappers;

import be.tftic.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.requests.DomainRequest;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.responses.DomainResponse;
import be.tftic.java.ulfgarstoolbox.domain.entities.Domain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface DomainMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "request.name", target = "name")
    @Mapping(source = "request.power", target = "power")
    Domain toEntity(
        DomainRequest request
    );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "power", target = "power")
    DomainResponse fromEntity(Domain entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "name", target = "name")
    @Mapping(source = "power", target = "power")
    void updateEntityFromRequest(
            DomainRequest request,
            @MappingTarget Domain domain
    );

    @Mapping(source = "page.content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())")
    @Mapping(source = "page.size", target = "pageSize")
    PagedResponse<DomainResponse> fromPage(Page<Domain> page);

}
