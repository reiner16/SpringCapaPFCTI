package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirecionRepository extends JpaRepository<Direccion, Integer> {

    void deleteAllByCliente_Id(int clienteId);

}
