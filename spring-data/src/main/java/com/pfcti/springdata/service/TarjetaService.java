package com.pfcti.springdata.service;

import com.pfcti.springdata.repository.InversionRepository;
import com.pfcti.springdata.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TarjetaService {

    TarjetaRepository tarjetaRepository;
}
