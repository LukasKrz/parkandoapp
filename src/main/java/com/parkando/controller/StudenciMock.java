//package com.parkando.controller;
//
//import com.parkando.model.Student;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class StudenciMock {
//    private static Map<Long, Student> studenci = new HashMap<Long, Student>();
//    private static Long idIndex = 3L;
//
//    static {
//        Student a = new Student(1L, "Juliusz", "Slowacki", "dzienny", 1111111L, "A1");
//        studenci.put(1L, a);
//        Student b = new Student(2L, "Wislawa", "Szymborska", "dzienny", 2222222L, "A2");
//        studenci.put(2L, b);
//        Student c = new Student(3L, "Zbigniew", "Herbert", "zaoczny", 3333333L, "A3");
//        studenci.put(3L, c);
//        Student d = new Student(4L, "Marcin", "Swietlicki", "zaoczny", 3333333L, null);
//        studenci.put(4L, d);
//        Student e = new Student(5L, "Rafal", "Wojaczek", "zaoczny", 3333333L, null);
//        studenci.put(5L, e);
//    }
//
//    public static List<Student> list() {
//        return new ArrayList<Student>(studenci.values());
//    }
//
//    public static Student create(Student student) {
//        idIndex += idIndex;
//        student.setId(idIndex);
//        studenci.put(idIndex, student);
//        return student;
//    }
//
//    public static Student get(Long id) {
//        return studenci.get(id);
//    }
//
//    public static Student update(Long id, Student student) {
//        studenci.put(id, student);
//        return student;
//    }
//
//    public static Student delete(Long id) {
//        return studenci.remove(id);
//    }
//}
