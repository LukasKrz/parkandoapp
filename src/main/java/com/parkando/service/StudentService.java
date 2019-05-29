package com.parkando.service;

import com.parkando.model.MiejscePodstawowe;
import com.parkando.model.Student;
import com.parkando.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MiejsceService miejsceService;

    public StudentZwalidowanyDO validateStudent(Long card_id) {
        List<Student> studentList = studentRepository.findAll();
        Student studentFromDb = studentList.stream().filter(student -> student.getCardId().equals(card_id)).findFirst().get();
        StudentDoWalidacjiDO studentDoWalidacjiDO = createStudentDOWalidacji(studentFromDb);

        List<MiejscePodstawowe> miejscePodstawowe = miejsceService.listPodstawowe();
        Long numerMiejsca = miejscePodstawowe.stream().filter(miejsce -> miejsce.getIdStudentDzienny().equals(card_id)).findFirst().get().getParkPlaceId();
        return createStudentZwalidowany(studentDoWalidacjiDO, numerMiejsca);
    }

    public StudentZwalidowanyDO validateStudentAndCheckMiejsce(StudentDoWalidacjiDO studentDoWalidacjiDO) {
        if (studentIsNotInDb(studentDoWalidacjiDO)){
            return createInvalidStudent(studentDoWalidacjiDO);
        } return createValidStudentAndCheckMiejsce(studentDoWalidacjiDO);
    }

    private boolean studentIsNotInDb(StudentDoWalidacjiDO studentDoWalidacjiDO) {
        return !studentRepository.findAll().stream().anyMatch(student -> student.getCardId().equals(studentDoWalidacjiDO.getCard_id())
                && student.getName().equals(studentDoWalidacjiDO.getName())
                && student.getSurname().equals(studentDoWalidacjiDO.getSurname()));
    }

    private StudentZwalidowanyDO createInvalidStudent(StudentDoWalidacjiDO studentDoWalidacjiDO) {
        StudentZwalidowanyDO studentZwalidowanyDO = new StudentZwalidowanyDO();
        studentZwalidowanyDO.setName(studentDoWalidacjiDO.getName());
        studentZwalidowanyDO.setSurname(studentDoWalidacjiDO.getSurname());
        return studentZwalidowanyDO;
    }

    private StudentZwalidowanyDO createValidStudentAndCheckMiejsce(StudentDoWalidacjiDO studentDoWalidacjiDO) {
        Student studentFromDb = retrieveStudentFromDb(studentDoWalidacjiDO);
        StudentZwalidowanyDO studentZwalidowanyDO = new StudentZwalidowanyDO();
        studentZwalidowanyDO.setUser_id(studentFromDb.getId());
        studentZwalidowanyDO.setCard_id(studentDoWalidacjiDO.getCard_id());
        studentZwalidowanyDO.setName(studentDoWalidacjiDO.getName());
        studentZwalidowanyDO.setSurname(studentDoWalidacjiDO.getSurname());
        studentZwalidowanyDO.setUser_type(studentFromDb.getUserType());
        List<MiejscePodstawowe> miejscaPodstawowe = miejsceService.listPodstawowe();
        if (miejscaPodstawowe.stream().anyMatch(miejscePodstawowe -> miejscePodstawowe.getIdStudentDzienny().equals(studentDoWalidacjiDO.getCard_id()))) {
            studentZwalidowanyDO.setPark_place_id(miejscaPodstawowe.stream()
                    .filter(miejscePodstawowe -> miejscePodstawowe.getIdStudentDzienny().equals(studentDoWalidacjiDO.getCard_id())).findFirst().get().getParkPlaceId());
            studentZwalidowanyDO.setPark_id("A");
        }
        return studentZwalidowanyDO;
    }

    private Student retrieveStudentFromDb(StudentDoWalidacjiDO studentDoWalidacjiDO) {
        return studentRepository.findAll().stream().filter(student -> student.getCardId().equals(studentDoWalidacjiDO.getCard_id())
                && student.getName().equals(studentDoWalidacjiDO.getName())
                && student.getSurname().equals(studentDoWalidacjiDO.getSurname())).collect(Collectors.toList()).get(0);
    }

    private StudentDoWalidacjiDO createStudentDOWalidacji(Student student) {
        return new StudentDoWalidacjiDO(student.getCardId(), student.getName(), student.getSurname());
    }

    private StudentZwalidowanyDO createStudentZwalidowany(StudentDoWalidacjiDO studentDoWalidacjiDO, Long numerMiejsca) {
        StudentZwalidowanyDO studentZwalidowanyDO = new StudentZwalidowanyDO();
        studentZwalidowanyDO.setUser_id(1L);
        studentZwalidowanyDO.setCard_id(studentDoWalidacjiDO.getCard_id());
        studentZwalidowanyDO.setName(studentDoWalidacjiDO.getName());
        studentZwalidowanyDO.setSurname(studentDoWalidacjiDO.getSurname());
        studentZwalidowanyDO.setUser_type("dzienny");
        studentZwalidowanyDO.setPark_id("A");
        studentZwalidowanyDO.setPark_place_id(1L);
        return studentZwalidowanyDO;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student create(@RequestBody Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public Optional<Student> get(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    public Student update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        existingStudent.get().setName(student.getName());
//        BeanUtils.copyProperties(student, existingStudent);
        return studentRepository.saveAndFlush(existingStudent.get());
    }

    public Student delete(@PathVariable Long id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        studentRepository.delete(existingStudent.get());
        return existingStudent.get();
    }
}