package be.tftic.java.ulfgarstoolbox.bll.services;

import be.tftic.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.tftic.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;

import java.util.Map;

public interface ICharacterClassService {

    PagedResponse<CharacterClassResponse> findAll(Map<String, String> params, int page, int pageSize);

    CharacterClassResponse findById(int id);

    CharacterClassResponse findByName(String className);

}
