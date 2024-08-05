package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IBonusSpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses.BonusSpellResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL + "/bonusSpell")
public class BonusSpellController {

    private final IBonusSpellService bonusSpellService;

    @GetMapping
    public ResponseEntity<List<BonusSpellResponse>> getAllBonusSpells() {
        return ResponseEntity.ok(bonusSpellService.getAll());
    }

    @GetMapping("/{abilityScore:\\d+}")
    public ResponseEntity<BonusSpellResponse> getByAbilityScore(
            @PathVariable Integer abilityScore
    ) {
        return ResponseEntity.ok(bonusSpellService.getByAbilityScore(abilityScore));
    }


}
