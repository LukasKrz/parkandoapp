package com.parkando.controller;

import com.parkando.model.MiejsceDodatkowe;
import com.parkando.model.MiejscePodstawowe;
import com.parkando.service.MiejsceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class MiejscaController {

    @Autowired
    private MiejsceService miejsceService;

    @RequestMapping(value = "miejsca/podstawoweall", method = RequestMethod.GET)
    public List<MiejscePodstawowe> listPodstawowe() {
        return miejsceService.listPodstawowe();
    }

    @RequestMapping(value = "miejsca/dodatkoweall", method = RequestMethod.GET)
    public List<MiejsceDodatkowe> listDodatkowe() {
        return miejsceService.listDodatkowe();
    }
}