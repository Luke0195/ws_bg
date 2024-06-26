package br.com.gobarber.controllers;

import br.com.gobarber.bunisses.UserService;
import br.com.gobarber.factories.UserFactory;
import br.com.gobarber.presenter.request.UserRequestDto;
import br.com.gobarber.presenter.response.UserResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("POST - should return 201 when valid data is provided")
    void creteShouldReturnAnUserWhenValidDataIsProvided() throws Exception {
        UserRequestDto userRequestDto = UserFactory.makeUserRequestDto();
        UserResponseDto userResponseDto = UserFactory.makeUserResponseDto(UserFactory.makeUser(userRequestDto));
        Mockito.when(userService.createUser(Mockito.any())).thenReturn(userResponseDto);
        String jsonBody = objectMapper.writeValueAsString(userRequestDto);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isCreated());
    }
}
