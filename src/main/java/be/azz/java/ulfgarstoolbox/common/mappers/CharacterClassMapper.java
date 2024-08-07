package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.CharacterClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CharacterClassMapper {

    CharacterClassResponse fromEntity(CharacterClass entity);

    @Mapping(source = "content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())")
    @Mapping(source = "size", target = "pageSize")
    PagedResponse<CharacterClassShortResponse> fromPage(Page<CharacterClass> page);

}
