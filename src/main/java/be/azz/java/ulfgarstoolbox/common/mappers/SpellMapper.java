package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.Spell;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpellMapper {

    @Named("toDetails")
    SpellDetailsResponse fromEntityToDetails(SpellDetails spellDetails);

    @Named("toShort")
    SpellShortResponse fromEntityToShort(SpellDetails spellDetails);

    @Mapping(source = "page.content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())", qualifiedByName = "toShort")
    @Mapping(source = "page.size", target = "pageSize")
    PagedResponse<SpellShortResponse> fromPage(Page<SpellDetails> page);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "spellClass", ignore = true)
    @Mapping(target = "spellDomains", ignore = true)
    Spell toEntity(SpellRequest spellRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "spellClass", ignore = true)
    @Mapping(target = "spellDomains", ignore = true)
    void updateEntityFromRequest(
            SpellRequest request,
            @MappingTarget Spell spell
    );
}