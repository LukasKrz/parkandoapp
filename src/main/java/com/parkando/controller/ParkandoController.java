package com.parkando.controller;

import com.parkando.model.Shipwreck;
import com.parkando.repository.ShipwreckRepository;
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
@RequestMapping("api/v1/")
public class ParkandoController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Optional<Shipwreck> get(@PathVariable Long id) {
        return shipwreckRepository.findById(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
        Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        return shipwreckRepository.saveAndFlush(existingShipwreck.get());
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id) {
        Optional<Shipwreck> existingShipwreck = shipwreckRepository.findById(id);
        shipwreckRepository.delete(existingShipwreck.get());
        return existingShipwreck.get();
    }

//    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
//    public List<Shipwreck> list() {
//        return ShipwreckStub.list();
//    }
//
//    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
//    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
//        return ShipwreckStub.create(shipwreck);
//    }
//
//    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
//    public Shipwreck get(@PathVariable Long id) {
//        return ShipwreckStub.get(id);
//    }
//
//    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
//    public Shipwreck update(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {
//        return ShipwreckStub.update(id, shipwreck);
//    }
//
//    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
//    public Shipwreck delete(@PathVariable Long id) {
//        return ShipwreckStub.delete(id);
//    }

}