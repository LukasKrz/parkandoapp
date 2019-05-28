package com.parkando.controller;

import com.parkando.model.Student;
import com.parkando.service.StudentService;
import com.parkando.service.StudentZwalidowanyDO;
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
public class StudentController {

    @RequestMapping(value = "studenci/walidacja/{card_id}", method = RequestMethod.GET)
    public StudentZwalidowanyDO waliduj(@PathVariable Long card_id) {
        return studentService.waliduj(card_id);
    }

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "studenci", method = RequestMethod.GET)
    public List<Student> list() {
        return studentService.list();
    }

    @RequestMapping(value = "studenci", method = RequestMethod.POST)
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.GET)
    public Optional<Student> get(@PathVariable Long id) {
        return studentService.get(id);
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.DELETE)
    public Student delete(@PathVariable Long id) {
        return studentService.delete(id);
    }
}
