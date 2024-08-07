package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.SpellSchool;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SpellSchoolMapper {

    SpellSchoolShortResponse fromEntityToShort(SpellSchool entity);
    SpellSchoolResponse fromEntity(SpellSchool entity);

}
