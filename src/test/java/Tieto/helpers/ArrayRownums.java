package Tieto.helpers;

import java.util.ArrayList;

/**
 * Created by zuevaolg on 23.03.2017.
 */
public class ArrayRownums {

    public ArrayList getRownumsArray(int countRowsInTable, int percent){
        int countRowsForMatch = (countRowsInTable*percent)/100;
        int increment = countRowsInTable/countRowsForMatch;
        ArrayList arrayRows = new ArrayList();
        //ArrayList<Integer> arrayRownums = new ArrayList<Integer>();
        return arrayRows;

    }
}
