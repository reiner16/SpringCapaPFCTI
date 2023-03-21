package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Direccion;
import com.pfcti.springdata.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InversionRepository extends JpaRepository<Inversion, Integer> {

    void deleteAllByCliente_Id(int clienteId);

}
