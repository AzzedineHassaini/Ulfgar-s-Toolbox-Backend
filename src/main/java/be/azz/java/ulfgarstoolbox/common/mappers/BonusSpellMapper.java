package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses.BonusSpellResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.BonusSpell;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BonusSpellMapper {

    BonusSpellResponse fromEntity(BonusSpell entity);

}
