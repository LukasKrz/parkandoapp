package com.parkando.controller;

import com.parkando.model.MiejscePodstawowe;
import com.parkando.repository.MiejscePodstawoweRepository;
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
public class MiejscaPodstawoweController {

    @Autowired
    private MiejscePodstawoweRepository miejscePodstawoweRepository;

    @RequestMapping(value = "miejsca/podstawowe", method = RequestMethod.GET)
    public List<MiejscePodstawowe> list() {
        return miejscePodstawoweRepository.findAll();
    }

    @RequestMapping(value = "miejsca/podstawowe", method = RequestMethod.POST)
    public MiejscePodstawowe create(@RequestBody MiejscePodstawowe miejscePodstawowe) {
        return miejscePodstawoweRepository.saveAndFlush(miejscePodstawowe);
    }

    @RequestMapping(value = "miejsca/podstawowe/{id}", method = RequestMethod.GET)
    public Optional<MiejscePodstawowe> get(@PathVariable Long id) {
        return miejscePodstawoweRepository.findById(id);
    }

    @RequestMapping(value = "miejsca/podstawowe/{id}", method = RequestMethod.PUT)
    public MiejscePodstawowe update(@PathVariable Long id, @RequestBody MiejscePodstawowe miejscePodstawowe) {
        Optional<MiejscePodstawowe> existingMiejsce = miejscePodstawoweRepository.findById(id);
        BeanUtils.copyProperties(miejscePodstawowe, existingMiejsce);
        return miejscePodstawoweRepository.saveAndFlush(existingMiejsce.get());
    }

    @RequestMapping(value = "miejsca/podstawowe/{id}", method = RequestMethod.DELETE)
    public MiejscePodstawowe delete(@PathVariable Long id) {
        Optional<MiejscePodstawowe> existingMiejsce = miejscePodstawoweRepository.findById(id);
        miejscePodstawoweRepository.delete(existingMiejsce.get());
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