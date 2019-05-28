package com.parkando.service;

import com.parkando.model.MiejsceDodatkowe;
import com.parkando.model.MiejscePodstawowe;
import com.parkando.repository.MiejsceDodatkoweRepository;
import com.parkando.repository.MiejscePodstawoweRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiejsceService {

    @Autowired
    private MiejsceDodatkoweRepository miejsceDodatkoweRepository;

    @Autowired
    private MiejscePodstawoweRepository miejscePodstawoweRepository;

    public List<MiejscePodstawowe> listPodstawowe() {
        return miejscePodstawoweRepository.findAll();
    }

    public List<MiejsceDodatkowe> listDodatkowe() {
        return miejsceDodatkoweRepository.findAll();
    }
}
