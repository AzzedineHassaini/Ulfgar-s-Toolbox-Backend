package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolShortResponse;

import java.util.List;

public interface ISpellSchoolService {

    List<SpellSchoolShortResponse> getAllSpellSchools();
    SpellSchoolResponse getSpellSchoolById(Long id);

}
