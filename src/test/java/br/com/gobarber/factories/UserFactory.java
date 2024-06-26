package br.com.gobarber.factories;

import br.com.gobarber.domain.User;
import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;

import java.time.Instant;

public class UserFactory {

    private UserFactory(){}


    public static UserRequestDto makeUserRequestDto(){
        return UserRequestDto.builder().name("any_name").email("any_mail@mail.com").password("any_password").build();
    }

    public static User makeUser(UserRequestDto userRequestDto){
        return User
                .builder()
                .id(1L)
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .createdAt(Instant.now())
                .build();
    }

    public static UserResponseDto makeUserResponseDto(User user){
        return UserResponseDto
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
