package br.com.gobarber.repositories;

import br.com.gobarber.domain.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("dev")
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setup(){
        this.userRepository.deleteAll();
    }

    @Test
    @DisplayName("CreateRepository should return an entity when valid data is provided")
    void saveShouldReturnAnEntityWhenValidDataIsProvided(){
        User user = User.builder().name("any_name").email("any_mail@mail.com").password("any_password").build();
        user = userRepository.save(user);
        Assertions.assertNotNull(user.getId());
    }

}
