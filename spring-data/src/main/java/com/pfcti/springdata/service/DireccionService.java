package com.pfcti.springdata.service;

import com.pfcti.springdata.repository.CuentaRepository;
import com.pfcti.springdata.repository.DirecionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DireccionService {
    DirecionRepository direccionRepository;
}
