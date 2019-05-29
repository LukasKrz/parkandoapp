package com.parkando.service;

import com.parkando.model.MiejsceDodatkowe;
import com.parkando.model.MiejscePodstawowe;
import com.parkando.model.CardIdDO;
import com.parkando.repository.MiejsceDodatkoweRepository;
import com.parkando.repository.MiejscePodstawoweRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MiejsceService {

    @Autowired
    private MiejsceDodatkoweRepository miejsceDodatkoweRepository;

    @Autowired
    private MiejscePodstawoweRepository miejscePodstawoweRepository;

    public List<MiejscePodstawowe> listDostepnePodstawoweD() {
        return miejscePodstawoweRepository.findAll().stream()
                .filter(miejscePodstawowe -> miejscePodstawowe.getDataRezerwacjiDzienny().isAfter(LocalDate.now().minusDays(7L))).collect(Collectors.toList());
    }

    public List<MiejscePodstawowe> listDostepnePodstawoweZ() {
        return miejscePodstawoweRepository.findAll().stream()
                .filter(miejscePodstawowe -> miejscePodstawowe.getDataRezerwacjiZaoczny().isAfter(LocalDate.now().minusDays(7L))).collect(Collectors.toList());
    }

    public List<MiejsceDodatkowe> listDostepneDodatkoweD() {
        return miejsceDodatkoweRepository.findAll().stream()
                .filter(miejscePodstawowe -> miejscePodstawowe.getDataRezerwacjiDzienny().isAfter(LocalDate.now().minusDays(7L))).collect(Collectors.toList());
    }

    public List<MiejsceDodatkowe> listDostepneDodatkoweZ() {
        return miejsceDodatkoweRepository.findAll().stream()
                .filter(miejscePodstawowe -> miejscePodstawowe.getDataRezerwacjiZaoczny().isAfter(LocalDate.now().minusDays(7L))).collect(Collectors.toList());
    }

    public MiejscePodstawowe bookPodstawoweD(Long id, CardIdDO cardIdDO) {
        Optional<MiejscePodstawowe> existingMiejsce = miejscePodstawoweRepository.findById(id);
        existingMiejsce.get().setIdStudentDzienny(cardIdDO.getCard_id());
        existingMiejsce.get().setDataRezerwacjiDzienny(LocalDate.now());
        return miejscePodstawoweRepository.saveAndFlush(existingMiejsce.get());
    }

    public MiejscePodstawowe bookPodstawoweZ(Long id, CardIdDO cardIdDO) {
        Optional<MiejscePodstawowe> existingMiejsce = miejscePodstawoweRepository.findById(id);
        existingMiejsce.get().setIdStudentZaoczny(cardIdDO.getCard_id());
        existingMiejsce.get().setDataRezerwacjiZaoczny(LocalDate.now());
        return miejscePodstawoweRepository.saveAndFlush(existingMiejsce.get());
    }

    public MiejsceDodatkowe bookDodatkoweD(Long id, CardIdDO cardIdDO) {
        Optional<MiejsceDodatkowe> existingMiejsce = miejsceDodatkoweRepository.findById(id);
        existingMiejsce.get().setIdStudentDzienny(cardIdDO.getCard_id());
        existingMiejsce.get().setDataRezerwacjiDzienny(LocalDate.now());
        return miejsceDodatkoweRepository.saveAndFlush(existingMiejsce.get());
    }

    public MiejsceDodatkowe bookDodatkoweZ(Long id, CardIdDO cardIdDO) {
        Optional<MiejsceDodatkowe> existingMiejsce = miejsceDodatkoweRepository.findById(id);
        existingMiejsce.get().setIdStudentZaoczny(cardIdDO.getCard_id());
        existingMiejsce.get().setDataRezerwacjiZaoczny(LocalDate.now());
        return miejsceDodatkoweRepository.saveAndFlush(existingMiejsce.get());
    }

    public List<MiejscePodstawowe> listPodstawowe() {
        return miejscePodstawoweRepository.findAll();
    }

    public List<MiejsceDodatkowe> listDodatkowe() {
        return miejsceDodatkoweRepository.findAll();
    }
}
