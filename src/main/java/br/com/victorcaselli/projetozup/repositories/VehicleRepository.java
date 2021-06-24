package br.com.victorcaselli.projetozup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorcaselli.projetozup.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
