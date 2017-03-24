package Tieto.tests;

import java.util.*;

public class MapComparator {

    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "Vasia");
        map1.put("surname", "Ivanov");
        map1.put("address", "Dubrovka");

        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
        map2.put("address", "Dubrovka");
        map2.put("name", new String("Vasia"));
        map2.put("surname", "Ivanov");

        System.out.println("Map1 = " + map1);
        System.out.println("Map2 = " + map2);
        System.out.println("Equality: " + map1.equals(map2));
        System.out.println("Comparison: " + compareMaps(map1, map2));
    }

    private static boolean compareMaps(Map<String, Object> map1, Map<String, Object> map2) {
        return map1.entrySet().containsAll(map2.entrySet()) && map2.entrySet().containsAll(map1.entrySet());
    }

}