package be.azz.java.ulfgarstoolbox.api.controllers;

import be.azz.java.ulfgarstoolbox.bll.services.IAdminService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.user.requests.UserUpdateRoleRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final IAdminService adminService;

    @PutMapping("/update/{id:^[0-9]$}")
    public ResponseEntity<UserShortResponse> updateUser(@PathVariable(name = "id") Long id,
                                                        @RequestBody @Valid UserUpdateRoleRequest request) {
        return ResponseEntity.ok(adminService.updateRole(id, request));
    }

    @DeleteMapping("/delete/{id:^[0-9]$}")
    public ResponseEntity<UserShortResponse> removeUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(adminService.deleteUser(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserShortResponse>> getAll() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

}