package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface SpellMapper {

    SpellDetailsResponse fromEntityToDetails(SpellDetails spellDetails);

    SpellShortResponse fromEntityToShort(SpellDetails spellDetails);

    @Mapping(source = "page.content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())")
    @Mapping(source = "page.size", target = "pageSize")
    PagedResponse<SpellShortResponse> fromPage(Page<SpellDetails> page);

}
