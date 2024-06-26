package br.com.gobarber.bunisses;

import br.com.gobarber.bunisses.mapper.UserMapper;
import br.com.gobarber.domain.User;
import br.com.gobarber.infra.exceptions.ResourceAlreadyExistsException;
import org.springframework.stereotype.Service;

import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;
import br.com.gobarber.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
  
  private final UserRepository userRepository;

  @Transactional
  public UserResponseDto createUser(UserRequestDto requestDto){
   Optional<User> findUserByEmail = userRepository.findUserByEmail(requestDto.getEmail());
   if(findUserByEmail.isPresent()) throw new ResourceAlreadyExistsException("This is e-mail is already taken!");
   User createdUser = UserMapper.mapUserRequestDtoToEntity(requestDto);
   createdUser = userRepository.save(createdUser);
   return UserMapper.mapUserToUserRequestDto(createdUser);
  }

}
