package com.pfcti.springdata.service;

import com.pfcti.springdata.dto.CuentaDto;
import com.pfcti.springdata.dto.InversionDto;
import com.pfcti.springdata.model.Cuenta;
import com.pfcti.springdata.model.Inversion;
import com.pfcti.springdata.repository.DirecionRepository;
import com.pfcti.springdata.repository.InversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InversionService {

    InversionRepository inversionRepository;


}
