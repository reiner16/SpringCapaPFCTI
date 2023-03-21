package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository  extends JpaRepository<Tarjeta, Integer> {

    void deleteAllByCliente_Id(int clienteId);
}
