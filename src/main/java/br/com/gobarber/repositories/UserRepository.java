package br.com.gobarber.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gobarber.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
