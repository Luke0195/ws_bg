package br.com.gobarber.controllers;

import br.com.gobarber.utils.http.HttpHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gobarber.bunisses.UserService;
import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.net.URI;

@RestController
@RequestMapping(value="/users")
@AllArgsConstructor
public class UserController {
  private final UserService userService;


  @PostMapping(value="/register")
  public ResponseEntity<UserResponseDto> create(@Valid @RequestBody UserRequestDto userRequestDto){
     UserResponseDto userResponseDto = userService.createUser(userRequestDto);
      URI uri = HttpHelper.addUriRequest(userResponseDto.getId());
      return ResponseEntity.created(uri).body(userResponseDto);
  }
}
