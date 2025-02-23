package LabFirst;

import java.util.ArrayList;
import java.util.List;
//
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                row.add(sum);
            }

            if (i > 0) {
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }
}
