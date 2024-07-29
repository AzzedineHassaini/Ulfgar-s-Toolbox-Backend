package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.tempTables.SpellDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpellMapper {

    SpellDetailsResponse fromEntityToDetails(SpellDetails spellDetails);

    SpellShortResponse fromEntityToShort(SpellDetails spellDetails);

}
