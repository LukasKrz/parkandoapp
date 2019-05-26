package com.parkando.controller;

import com.parkando.model.Student;
import com.parkando.repository.StudentRepository;
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
public class StudentController {

//    @RequestMapping(value = "studenci", method = RequestMethod.GET)
//    public List<Student> list() {
//        return StudenciMock.list();
//    }
//
//    @RequestMapping(value = "studenci", method = RequestMethod.POST)
//    public Student create(@RequestBody Student student) {
//        return StudenciMock.create(student);
//    }
//
//    @RequestMapping(value = "studenci/{id}", method = RequestMethod.GET)
//    public Student get(@PathVariable Long id) {
//        return StudenciMock.get(id);
//    }
//
//    @RequestMapping(value = "studenci/{id}", method = RequestMethod.PUT)
//    public Student update(@PathVariable Long id, @RequestBody Student student) {
//        return StudenciMock.update(id, student);
//    }
//
//    @RequestMapping(value = "studenci/{id}", method = RequestMethod.DELETE)
//    public Student delete(@PathVariable Long id) {
//        return StudenciMock.delete(id);
//    }

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value = "studenci", method = RequestMethod.GET)
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "studenci", method = RequestMethod.POST)
    public Student create(@RequestBody Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.GET)
    public Optional<Student> get(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.PUT)
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        BeanUtils.copyProperties(student, existingStudent);
        return studentRepository.saveAndFlush(existingStudent.get());
    }

    @RequestMapping(value = "studenci/{id}", method = RequestMethod.DELETE)
    public Student delete(@PathVariable Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        studentRepository.delete(existingStudent.get());
        return existingStudent.get();
    }
}
