package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellDetailsService;
import be.azz.java.ulfgarstoolbox.bll.services.ISpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.ViewSpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL + "/spells")
public class SpellController {

    private final ISpellDetailsService spellDetailsService;
    private final ISpellService spellService;

    @GetMapping
    public ResponseEntity<PagedResponse<SpellShortResponse>> getAllSpells(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return ResponseEntity.ok(spellDetailsService.getAllSpells(params, page, pageSize));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<ViewSpellDetailsResponse> getSpellDetails(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(spellDetailsService.getSpellDetails(id));
    }

    @GetMapping("/form/{id:\\d+}")
    public ResponseEntity<SpellDetailsResponse> getSpellDetailsForm(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(spellDetailsService.getSpellDetailsForm(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR')")
    @PostMapping()
    public ResponseEntity<ViewSpellDetailsResponse> createSpell(
            @RequestBody @Valid SpellRequest spellRequest
    ){
        return ResponseEntity.ok(spellService.addSpell(spellRequest));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR')")
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<ViewSpellDetailsResponse> updateSpell(
            @PathVariable Integer id,
            @RequestBody @Valid SpellRequest spellRequest
    ){
        return ResponseEntity.ok(spellService.updateSpell(id, spellRequest));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR')")
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<ViewSpellDetailsResponse> deleteSpell(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(spellService.deleteSpell(id));
    }

}
