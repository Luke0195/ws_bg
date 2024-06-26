package br.com.gobarber.bunisses.mapper;

import br.com.gobarber.domain.User;
import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;

public class UserMapper {

  public static User mapUserRequestDtoToEntity(UserRequestDto userRequestDto){
       return User
               .builder()
               .name(userRequestDto.getName())
               .email(userRequestDto.getEmail())
               .password(userRequestDto.getPassword())
               .thumbnail(null).build();
   }

  public static UserResponseDto mapUserToUserRequestDto(User entity){
       return UserResponseDto.builder()
               .id(entity.getId())
               .name(entity.getName())
               .email(entity.getEmail())
               .password(entity.getPassword())
               .createdAt(entity.getCreatedAt())
               .updatedAt(entity.getUpdatedAt())
               .build();
   }
}
