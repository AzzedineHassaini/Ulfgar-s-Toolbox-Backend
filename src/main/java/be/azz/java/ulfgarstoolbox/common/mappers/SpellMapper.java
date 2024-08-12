package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.ViewSpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellHistoryResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.Spell;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetailsForm;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellHistory;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {SpellMapper.class})
public interface SpellMapper {

    @Named("toDetails")
    ViewSpellDetailsResponse fromEntityToDetails(SpellDetails spellDetails);

    @Named("toDetailsForm")
    @Mapping(target = "classLevels", source = "classLevels", qualifiedByName = "stringToMap")
    @Mapping(target = "domainLevels", source = "domainLevels", qualifiedByName = "stringToMap")
    SpellDetailsResponse fromEntityToDetailsForm(SpellDetailsForm spellDetails);

    @Named("toShort")
    SpellShortResponse fromEntityToShort(SpellDetails spellDetails);

    @Named("toHistory")
    SpellHistoryResponse fromEntity(SpellHistory spellHistory);

    @Mapping(source = "content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())", qualifiedByName = "toShort")
    @Mapping(source = "size", target = "pageSize")
    PagedResponse<SpellShortResponse> fromPage(Page<SpellDetails> page);

    @Mapping(source = "content", target = "content", defaultExpression = "java(java.util.Collections.emptyList())", qualifiedByName = "toHistory")
    @Mapping(source = "size", target = "pageSize")
    PagedResponse<SpellHistoryResponse> fromPageToHistory(Page<SpellHistory> page);

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

    @Named("stringToMap")
    default Map<Integer, Integer> stringToMap(String value) {
        if (value == null || value.isEmpty()) {
            return Map.of();
        }
        return Arrays.stream(value.split(";"))
                .map(s -> s.split(":"))
                .collect(Collectors.toMap(
                        arr -> Integer.parseInt(arr[0]),
                        arr -> Integer.parseInt(arr[1])
                ));
    }
}