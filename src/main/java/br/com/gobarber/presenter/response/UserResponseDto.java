package br.com.gobarber.presenter.response;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto implements Serializable{

  private Long id;
  private String name;
  private String email;
  private String password;
  private Instant createdAt;
  private Instant updatedAt;
  
}
