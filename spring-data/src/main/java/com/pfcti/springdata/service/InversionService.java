package com.pfcti.springdata.service;

import com.pfcti.springdata.repository.DirecionRepository;
import com.pfcti.springdata.repository.InversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InversionService {

    InversionRepository inversionRepository;
}
