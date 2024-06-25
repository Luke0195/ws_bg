package br.com.gobarber.presenter.request;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto implements Serializable{
  @NotBlank(message = "The field name is required")
  private String name;  
  @NotBlank(message = "The field email is required")
  @Email(message = "Please provide a valid e-mail")
  private String email;
  @NotBlank(message = "The field password is required")
  private String password;


}
