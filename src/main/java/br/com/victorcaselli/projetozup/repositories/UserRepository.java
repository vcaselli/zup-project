package br.com.victorcaselli.projetozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorcaselli.projetozup.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
