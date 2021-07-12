package math;

import java.util.ArrayList;
import java.util.List;

public class MultiPlyTest {


    public static void main(String[] args) {
        multiply(8, new ArrayList<>());
    }

    public static void multiply(int orgNum, ArrayList<Integer> result) {

        if (result.size() > 1 && orgNum == 1) {
            System.out.println(result);
            return;
        }

        for (int i = orgNum; i >= 1; i--) {
            if (orgNum % i == 0) {
                ArrayList<Integer> newResult = (ArrayList<Integer>) (result.clone());
                newResult.add(i);
                multiply(orgNum / i, newResult);
            }
        }

    }


}
