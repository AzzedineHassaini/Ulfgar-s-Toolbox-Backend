package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellSchoolService;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolShortResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("spell-school")
public class SpellSchoolController {

    private final ISpellSchoolService spellSchoolService;

    @GetMapping
    public ResponseEntity<List<SpellSchoolShortResponse>> getAll() {
        return ResponseEntity.ok(spellSchoolService.getAllSpellSchools());
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SpellSchoolResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(spellSchoolService.getSpellSchoolById(id));
    }

}
