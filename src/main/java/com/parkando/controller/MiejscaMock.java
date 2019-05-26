//package com.parkando.controller;
//
//import com.parkando.model.MiejscePodstawowe;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MiejscaMock {
//    private static Map<Long, MiejscePodstawowe> miejsca = new HashMap<Long, MiejscePodstawowe>();
//    private static Long idIndex = 3L;
//
////    static {
////        MiejscePodstawowe a = new MiejscePodstawowe(1L, "A1", 1L, Date.valueOf(LocalDate.now()));
////        miejsca.put(1L, a);
////        MiejscePodstawowe b = new MiejscePodstawowe(2L, "A2", 2L, Date.valueOf(LocalDate.now()));
////        miejsca.put(2L, b);
////        MiejscePodstawowe c = new MiejscePodstawowe(3L, "A3", 3L, Date.valueOf(LocalDate.now()));
////        miejsca.put(3L, c);
////    }
//
//    public static List<MiejscePodstawowe> list() {
//        return new ArrayList<MiejscePodstawowe>(miejsca.values());
//    }
//
//    public static MiejscePodstawowe create(MiejscePodstawowe wreck) {
//        idIndex += idIndex;
//        wreck.setId(idIndex);
//        miejsca.put(idIndex, wreck);
//        return wreck;
//    }
//
//    public static MiejscePodstawowe get(Long id) {
//        return miejsca.get(id);
//    }
//
//    public static MiejscePodstawowe update(Long id, MiejscePodstawowe miejscePodstawowe) {
//        miejsca.put(id, miejscePodstawowe);
//        return miejscePodstawowe;
//    }
//
//    public static MiejscePodstawowe delete(Long id) {
//        return miejsca.remove(id);
//    }
//}
