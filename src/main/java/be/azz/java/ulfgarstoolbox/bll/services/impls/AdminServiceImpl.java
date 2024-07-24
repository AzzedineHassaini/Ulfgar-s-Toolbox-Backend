package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.IAdminService;
import be.azz.java.ulfgarstoolbox.common.dtos.user.requests.UserUpdateRoleRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.auth.UserNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.UserMapper;
import be.azz.java.ulfgarstoolbox.dal.repository.UserRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.User;
import be.azz.java.ulfgarstoolbox.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements IAdminService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserShortResponse updateRole(Long id, UserUpdateRoleRequest request) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        user.setRole(Role.valueOf(request.role().toUpperCase()));
        userRepository.save(user);

        return userMapper.fromEntity(user);
    }

    @Override
    public UserShortResponse deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);

        return userMapper.fromEntity(user);
    }

    @Override
    public List<UserShortResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::fromEntity)
                .toList();
    }

}
