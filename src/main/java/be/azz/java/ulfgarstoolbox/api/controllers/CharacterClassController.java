package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ICharacterClassService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassShortResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL + "/classes")
public class CharacterClassController {

    private final ICharacterClassService characterClassService;

    @GetMapping
    public ResponseEntity<PagedResponse<CharacterClassShortResponse>> getAllClasses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize)
    {
        return ResponseEntity.ok(characterClassService.findAll(page, pageSize));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<CharacterClassResponse> getById(
            @PathVariable(name = "id") Integer id)
    {
        return ResponseEntity.ok(characterClassService.findById(id));
    }

}
