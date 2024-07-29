package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.CharacterClass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CharacterClassMapper {

    CharacterClassResponse fromEntity(CharacterClass entity);

    @Mapping(source = "page.content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())")
    @Mapping(source = "page.size", target = "pageSize")
    PagedResponse<CharacterClassShortResponse> fromPage(Page<CharacterClass> page);

}
