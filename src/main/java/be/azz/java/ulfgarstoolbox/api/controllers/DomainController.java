package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IDomainService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.domain.requests.DomainRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.domain.responses.DomainResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL + "/domains")
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

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<DomainResponse> getDomainById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(domainService.findById(id));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR')")
    @PostMapping
    public ResponseEntity<DomainResponse> addDomain(@RequestBody @Valid DomainRequest request){
        return ResponseEntity.ok(domainService.addDomain(request));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','CONTRIBUTOR')")
    @PutMapping("/{id:\\d+}")
    public ResponseEntity<DomainResponse> updateDomain(@PathVariable("id") Integer id,
                                                       @RequestBody @Valid DomainRequest request){
        return ResponseEntity.ok(domainService.updateDomain(id, request));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/{id:\\d+}")
    public ResponseEntity<DomainResponse> deleteDomain(@PathVariable("id") Integer id){
        return ResponseEntity.ok(domainService.deleteDomain(id));
    }

}
