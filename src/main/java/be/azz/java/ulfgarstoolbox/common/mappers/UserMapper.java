package be.azz.java.ulfgarstoolbox.common.mappers;

import be.azz.java.ulfgarstoolbox.common.dtos.user.responses.UserShortResponse;
import be.azz.java.ulfgarstoolbox.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "pseudo", target = "pseudo")
    @Mapping(source = "role", target = "role")
    UserShortResponse fromEntity(User entity);

}
