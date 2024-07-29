package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IBonusSpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses.BonusSpellResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bonusSpell")
public class BonusSpellController {

    private final IBonusSpellService bonusSpellService;

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping
    public ResponseEntity<List<BonusSpellResponse>> getAllBonusSpells() {
        return ResponseEntity.ok(bonusSpellService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    @GetMapping("/{abilityScore:^[0-9]$}")
    public ResponseEntity<BonusSpellResponse> getByAbilityScore(
            @PathVariable Integer abilityScore
    ) {
        return ResponseEntity.ok(bonusSpellService.getByAbilityScore(abilityScore));
    }


}
