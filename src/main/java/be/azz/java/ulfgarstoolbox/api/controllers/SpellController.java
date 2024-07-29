package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/spells")
public class SpellController {

    private final ISpellService spellService;

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping
    public ResponseEntity<PagedResponse<SpellShortResponse>> getAllSpells(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        return ResponseEntity.ok(spellService.getAllSpells(params, page, pageSize));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SpellDetailsResponse> getSpellDetails(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(spellService.getSpellDetails(id));
    }

}
