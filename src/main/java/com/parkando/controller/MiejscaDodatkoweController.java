package com.parkando.controller;

import com.parkando.model.MiejsceDodatkowe;
import com.parkando.repository.MiejsceDodatkoweRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class MiejscaDodatkoweController {

    @Autowired
    private MiejsceDodatkoweRepository miejsceDodatkoweRepository;

    @RequestMapping(value = "miejsca/dodatkowe", method = RequestMethod.GET)
    public List<MiejsceDodatkowe> list() {
        return miejsceDodatkoweRepository.findAll();
    }

    @RequestMapping(value = "miejsca/dodatkowe", method = RequestMethod.POST)
    public MiejsceDodatkowe create(@RequestBody MiejsceDodatkowe miejsce) {
        return miejsceDodatkoweRepository.saveAndFlush(miejsce);
    }

    @RequestMapping(value = "miejsca/dodatkowe/{id}", method = RequestMethod.GET)
    public Optional<MiejsceDodatkowe> get(@PathVariable Long id) {
        return miejsceDodatkoweRepository.findById(id);
    }

    @RequestMapping(value = "miejsca/dodatkowe/{id}", method = RequestMethod.PUT)
    public MiejsceDodatkowe update(@PathVariable Long id, @RequestBody MiejsceDodatkowe miejsce) {
        Optional<MiejsceDodatkowe> existingMiejsce = miejsceDodatkoweRepository.findById(id);
        BeanUtils.copyProperties(miejsce, existingMiejsce);
        return miejsceDodatkoweRepository.saveAndFlush(existingMiejsce.get());
    }

    @RequestMapping(value = "miejsca/dodatkowe/{id}", method = RequestMethod.DELETE)
    public MiejsceDodatkowe delete(@PathVariable Long id) {
        Optional<MiejsceDodatkowe> existingMiejsce = miejsceDodatkoweRepository.findById(id);
        miejsceDodatkoweRepository.delete(existingMiejsce.get());
        return existingMiejsce.get();
    }

    //    @RequestMapping(value = "miejsca", method = RequestMethod.GET)
//    public List<MiejscePodstawowe> list() {
//        return MiejscaMock.list();
//    }
//
//    @RequestMapping(value = "miejsca", method = RequestMethod.POST)
//    public MiejscePodstawowe create(@RequestBody MiejscePodstawowe miejsce) {
//        return MiejscaMock.create(miejsce);
//    }
//
//    @RequestMapping(value = "miejsca/{id}", method = RequestMethod.GET)
//    public MiejscePodstawowe get(@PathVariable Long id) {
//        return MiejscaMock.get(id);
//    }
//
//    @RequestMapping(value = "miejsca/{id}", method = RequestMethod.PUT)
//    public MiejscePodstawowe update(@PathVariable Long id, @RequestBody MiejscePodstawowe miejsce) {
//        return MiejscaMock.update(id, miejsce);
//    }
//
//    @RequestMapping(value = "miejsca/{id}", method = RequestMethod.DELETE)
//    public MiejscePodstawowe delete(@PathVariable Long id) {
//        return MiejscaMock.delete(id);
//    }
}