package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellDetailsService;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellPrintableResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + "/print")
@RequiredArgsConstructor
public class PrintSpellController {

    private final ISpellDetailsService spellDetailsService;
    private final TemplateEngine templateEngine;

    @GetMapping
    public ResponseEntity<byte[]> printSpellList(@RequestParam String classOrDomain, @RequestParam String type) {

        List<SpellPrintableResponse> spells = spellDetailsService.getAllPrintableSpells(classOrDomain, type);

        Map<Integer, Map<String, List<SpellPrintableResponse>>> spellsByLevel = spells.stream()
                .collect(Collectors.groupingBy(SpellPrintableResponse::level,
                        Collectors.groupingBy(SpellPrintableResponse::school)));

        Context context = new Context();
        context.setVariable("classOrDomain", classOrDomain);
        context.setVariable("type", (type.equals("class") ? "Classe" : "Domaine"));
        context.setVariable("spellsByLevel", spellsByLevel);

        String htmlContent = templateEngine.process("fiche-sorts", context);

        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(output);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", "fiche_sorts.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(output.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
