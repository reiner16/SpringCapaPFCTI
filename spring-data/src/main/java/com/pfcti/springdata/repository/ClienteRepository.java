package com.pfcti.springdata.repository;

import com.pfcti.springdata.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> , JpaSpecificationExecutor<Cliente> {

    List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);

    @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
    List<Cliente> buscarPorApellidos(String apellidos);

    @Query(value = "select nombre,apellidos,cedula,telefono,id from cliente where apellidos := apellidos",
            nativeQuery = true)
    List<Tuple>  buscarPorApellidosNativo(String apellidos);

    //Esta parte no me compilo
    //@Query(value = "select c from Cliente c inner join tarjeta t where c.id = t.id and c.paisNacimiento <> 'CRC' ")
    //List<Cliente> buscarClientesExtranjerosConTarjetasInactivas();
}
