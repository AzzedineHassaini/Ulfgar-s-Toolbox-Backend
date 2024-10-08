package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassShortResponse;

import java.util.List;

public interface ICharacterClassService {

    PagedResponse<CharacterClassShortResponse> findAll(int page, int pageSize);

    CharacterClassResponse findById(int id);

    List<CharacterClassShortResponse> findAllCasterClasses();

}
