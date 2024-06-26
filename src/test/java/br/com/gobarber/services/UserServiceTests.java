package br.com.gobarber.services;

import br.com.gobarber.bunisses.UserService;
import br.com.gobarber.domain.User;
import br.com.gobarber.factories.UserFactory;
import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;
import br.com.gobarber.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;


    @Test
    @DisplayName("Create should return UserResponseDto on sucess")
    void createShouldReturnUserResponseDtoWhenValidDataIsProvided(){
        UserRequestDto requestDto = UserFactory.makeUserRequestDto();
        User user = UserFactory.makeUser(requestDto);
        Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
        UserResponseDto responseDto = userService.createUser(requestDto);
        Assertions.assertNotNull(responseDto.getId());
        Assertions.assertNotNull(responseDto.getName());
        Assertions.assertNotNull(responseDto.getEmail());
        Assertions.assertNotNull(responseDto.getPassword());
    }
}
