package be.tftic.java.ulfgarstoolbox.api.controllers;

import be.tftic.java.ulfgarstoolbox.bll.services.IDomainService;
import be.tftic.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.requests.DomainRequest;
import be.tftic.java.ulfgarstoolbox.common.dtos.domain.responses.DomainResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/domains")
public class DomainController {

    private final IDomainService domainService;

    @GetMapping
    public ResponseEntity<PagedResponse<DomainResponse>> getAllDomains(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize)
    {
        return ResponseEntity.ok(domainService.findAll(params, page, pageSize));
    }

    @GetMapping("/{id:^[0-9]+$}")
    public ResponseEntity<DomainResponse> getDomainById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(domainService.findById(id));
    }

    @GetMapping("/{name}")
    public ResponseEntity<DomainResponse> getDomainByName(@PathVariable("name") String name){
        return ResponseEntity.ok(domainService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<DomainResponse> addDomain(@RequestBody @Valid DomainRequest request){
        return ResponseEntity.ok(domainService.addDomain(request));
    }

    @PutMapping("/{id:^[0-9]+$}")
    public ResponseEntity<DomainResponse> updateDomain(@PathVariable("id") Integer id,
                                                       @RequestBody @Valid DomainRequest request){
        return ResponseEntity.ok(domainService.updateDomain(id, request));
    }

    @DeleteMapping("/{id:^[0-9]+$}")
    public ResponseEntity<DomainResponse> deleteDomain(@PathVariable("id") Integer id){
        return ResponseEntity.ok(domainService.deleteDomain(id));
    }

}
