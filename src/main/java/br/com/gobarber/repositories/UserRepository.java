package br.com.gobarber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gobarber.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value = "SELECT obj FROM User obj where obj.email =:email")
    Optional<User> findUserByEmail(String email);
}
