package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IAdminService;
import be.azz.java.ulfgarstoolbox.bll.services.ISpellHistoryService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellHistoryResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.user.requests.UserUpdateRoleRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import be.azz.java.ulfgarstoolbox.config.utils.Constants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constants.API_URL + "/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final IAdminService adminService;
    private final ISpellHistoryService spellHistoryService;

    @PutMapping("/update/{id:\\d+}")
    public ResponseEntity<UserShortResponse> updateUser(@PathVariable(name = "id") Long id,
                                                        @RequestBody @Valid UserUpdateRoleRequest request) {
        return ResponseEntity.ok(adminService.updateRole(id, request));
    }

    @DeleteMapping("/delete/{id:\\d+}")
    public ResponseEntity<UserShortResponse> removeUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(adminService.deleteUser(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserShortResponse>> getAll() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/spell-history")
    public ResponseEntity<PagedResponse<SpellHistoryResponse>> getSpellHistory(
            @RequestParam Map<String, String> params,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String sortField,
            @RequestParam int sortOrder)
    {
        return ResponseEntity.ok(spellHistoryService.getSpellHistory(params, page, pageSize, sortField, sortOrder));
    }

}
