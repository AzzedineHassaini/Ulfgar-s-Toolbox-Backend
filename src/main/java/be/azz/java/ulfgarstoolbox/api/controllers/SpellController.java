package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spells")
public class SpellController {

    private final ISpellService spellService;

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping
    public ResponseEntity<List<SpellShortResponse>> getAllSpells() {
        return ResponseEntity.ok(spellService.getAllSpells());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SpellDetailsResponse> getSpellDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(spellService.getSpellDetails(id));
    }

}
