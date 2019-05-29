package com.parkando.controller;

import com.parkando.model.MiejscePodstawowe;
import com.parkando.model.MiejsceDodatkowe;
import com.parkando.model.Student;
import com.parkando.repository.MiejsceDodatkoweRepository;
import com.parkando.repository.MiejscePodstawoweRepository;
import com.parkando.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private MiejscePodstawoweRepository miejscePodstawoweRepository;

    private MiejsceDodatkoweRepository miejsceDodatkoweRepository;

    private StudentRepository studentRepository;

    @Autowired
    public CommandLineAppStartupRunner(MiejscePodstawoweRepository miejscePodstawoweRepository,
                                       MiejsceDodatkoweRepository miejsceDodatkoweRepository,
                                       StudentRepository studentRepository) {
        this.miejscePodstawoweRepository = miejscePodstawoweRepository;
        this.miejsceDodatkoweRepository = miejsceDodatkoweRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<MiejscePodstawowe> miejscaPodstawoweList = miejscePodstawoweRepository.findAll();
        fillMiejscaPodstawowe();
        fillMiejscaDodatkowe();
        fillStudent();
    }

    private void fillMiejscaDodatkowe() {
        List<MiejsceDodatkowe> miejscaDodatkowe = createMiejscaDodatkowe();
        for (MiejsceDodatkowe miejsce : miejscaDodatkowe) {
            miejsceDodatkoweRepository.save(miejsce);
        }
    }

    private void fillMiejscaPodstawowe() {
        List<MiejscePodstawowe> miejscaPodstawowe = createMiejscaPodstawowe();
        for (MiejscePodstawowe miejscePodstawowe : miejscaPodstawowe) {
            miejscePodstawoweRepository.save(miejscePodstawowe);
        }
    }


    private void fillStudent() {
        List<Student> studenci = createStudenci();
        for (Student student : studenci) {
            studentRepository.save(student);
        }
    }

    private List<MiejscePodstawowe> createMiejscaPodstawowe() {
        MiejscePodstawowe m1 = new MiejscePodstawowe("A", 1L, 101L, LocalDate.now(), 2L, LocalDate.now());
        MiejscePodstawowe m2 = new MiejscePodstawowe("A", 2L, 3L, LocalDate.now(), 4L, LocalDate.now());
        MiejscePodstawowe m3 = new MiejscePodstawowe("A", 3L, 5L, LocalDate.now().minusDays(10L), 6L, LocalDate.now());
        MiejscePodstawowe m4 = new MiejscePodstawowe("A", 4L, 7L, LocalDate.now(), 8L, LocalDate.now());
        MiejscePodstawowe m5 = new MiejscePodstawowe("A", 5L, 9L, LocalDate.now(), 10L, LocalDate.now());
        MiejscePodstawowe m6 = new MiejscePodstawowe("A", 6L, 11L, LocalDate.now().minusDays(8L), 12L, LocalDate.now());
        MiejscePodstawowe m7 = new MiejscePodstawowe("A", 7L, 13L, LocalDate.now(), 14L, LocalDate.now());
        List<MiejscePodstawowe> miejsca = new ArrayList<>();
        miejsca.addAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7));
        return miejsca;
    }

    private List<MiejsceDodatkowe> createMiejscaDodatkowe() {
        MiejsceDodatkowe m8 = new MiejsceDodatkowe("A", 8L, 1L, LocalDate.now(), 2L, LocalDate.now());
        MiejsceDodatkowe m9 = new MiejsceDodatkowe("A", 9L, null, null, 4L, LocalDate.now());
        MiejsceDodatkowe m10 = new MiejsceDodatkowe("A", 10L, 5L, LocalDate.now(), 6L, LocalDate.now().minusDays(10));
        List<MiejsceDodatkowe> miejsca = new ArrayList<>();
        miejsca.addAll(Arrays.asList(m8, m9, m10));
        return miejsca;
    }

    private List<Student> createStudenci() {
        Student s1 = new Student(101L, "Kunegunda", "Trupinska", "dzienny", "d.awid@interia.pl");
        Student s2 = new Student(102L, "Joanna", "Kosteczka", "zaoczny", "d.awid@interia.pl");
        Student s3 = new Student(103L, "Teodor", "Skostnialy", "dzienny", "d.awid@interia.pl");
        Student s4 = new Student(104L, "Kornelia", "Zmrok", "zaoczny", "d.awid@interia.pl");
        Student s5 = new Student(105L, "Adam", "Mickiewicz", "dzienny", "d.awid@interia.pl");
        Student s6 = new Student(106L, "Juliusz", "Slowacki", "zaoczny", "d.awid@interia.pl");
        Student s7 = new Student(107L, "Leopld", "Staff", "dzienny", "d.awid@interia.pl");
        Student s8 = new Student(108L, "Wislawa", "Szymborska", "zaoczny", "d.awid@interia.pl");
        Student s9 = new Student(109L, "Halina", "Poswiatowska", "dzienny", "d.awid@interia.pl");
        Student s10 = new Student(110L, "Jan", "Brzechwa", "zaoczny", "d.awid@interia.pl");
        Student s11 = new Student(111L, "Zbigniew", "Herbert", "dzienny", "d.awid@interia.pl");
        Student s12 = new Student(112L, "Mikolaj", "Rej", "zaoczny", "d.awid@interia.pl");
        Student s13 = new Student(113L, "Ignacy", "Krasicki", "dzienny", "d.awid@interia.pl");
        Student s14 = new Student(114L, "Boleslaw", "Lesmian", "zaoczny", "d.awid@interia.pl");
        List<Student> studenci = new ArrayList<>();
        studenci.addAll(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14));
        return studenci;
    }
}