package Tieto.helpers;

import java.util.ArrayList;

/**
 * Created by zuevaolg on 23.03.2017.
 */
public class ArrayRownums {

    public ArrayList getArray(int countRowsInTable, int percent) {

        int countRowsForMatch = (countRowsInTable * percent) / 100;
        int increment = countRowsInTable / countRowsForMatch;
        ArrayList arrayRows = new ArrayList();
        for (int i = 1; i < (countRowsInTable - increment); i = i + increment) {
            arrayRows.add(i);
        }
        System.out.println("ArraySize: " + arrayRows.size());
        return arrayRows;
    }
}
