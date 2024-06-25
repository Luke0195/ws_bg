package br.com.gobarber.bunisses;

import org.springframework.stereotype.Service;

import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;
import br.com.gobarber.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  
  private final UserRepository userRepository;


  @Transactional
  public UserResponseDto createUser(UserRequestDto requestDto){
    return null;
  }
}
