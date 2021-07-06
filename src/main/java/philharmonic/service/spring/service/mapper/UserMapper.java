package philharmonic.service.spring.service.mapper;

import org.springframework.stereotype.Component;
import philharmonic.service.spring.dto.response.UserResponseDto;
import philharmonic.service.spring.model.User;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
