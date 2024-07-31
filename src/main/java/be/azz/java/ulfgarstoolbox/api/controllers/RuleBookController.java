package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IRuleBookService;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.ruleBook.RuleBookShortResponse;
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
@RequestMapping("/v1/rulebooks")
public class RuleBookController {

    private final IRuleBookService ruleBookService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    public ResponseEntity<List<RuleBookShortResponse>> getAllRuleBooks() {
        return ResponseEntity.ok(ruleBookService.getAllRuleBooks());
    }

    @GetMapping("/{id:\\d+}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR','USER')")
    public ResponseEntity<RuleBookResponse> getRuleBookById(@PathVariable Long id) {
        return ResponseEntity.ok(ruleBookService.getRuleBookById(id));
    }

}
