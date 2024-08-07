package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.Spell;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {SpellMapper.class})
public interface SpellMapper {

    @Named("toDetails")
    SpellDetailsResponse fromEntityToDetails(SpellDetails spellDetails);

    @Named("toShort")
    SpellShortResponse fromEntityToShort(SpellDetails spellDetails);

    @Mapping(source = "content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())", qualifiedByName = "toShort")
    @Mapping(source = "size", target = "pageSize")
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

    default String combineLevels(String classLevels, String domainLevels) {
        StringBuilder combined = new StringBuilder();
        if (classLevels != null && !classLevels.isEmpty()) {
            combined.append(classLevels);
        }
        if (domainLevels != null && !domainLevels.isEmpty()) {
            if (!combined.isEmpty()) {
                combined.append(";");
            }
            combined.append(domainLevels);
        }
        return combined.toString();
    }
}