package Tieto.tests;

import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        getArray(1340, 10);

    }

    private static void getArray(int countRowsInTable, int percent) {

        int countRowsForMatch = (countRowsInTable * percent) / 100;
        int increment = countRowsInTable / countRowsForMatch;
        ArrayList arrayRows = new ArrayList();
        for (int i = 1; i < (countRowsInTable - increment); i = i + increment) {
            arrayRows.add(i);
        }
    }


    //int[] array = new int[]{1,};

    //int math =
    //ArrayList arrayRownums = new ArrayList();
    //arrayRownums.add(1);
    //for (int i = 1; i < countRowsInTable; i++) {
    // arrayRownums.add(increment);
    //}
    // System.out.println(arrayRownums.size());
}

