package inc.softserve.lv_448.java.algo.dynamic_programming;

import java.util.Scanner;

public class PathWithoutCrossing {

    public void run() {
        System.out.println("Number of crossing paths: " + calculate(input()));
    }

    private int input(){
        int pointCount = 0;
        String line = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");

        try {
            line = scanner.nextLine();
            pointCount = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect number:");
        }
        return pointCount;
    }

    protected int calculate(int pointCount){
        if (pointCount % 2 != 0 || pointCount < 1) {
            return pointCount = 0;
        }
        pointCount = pointCount / 2;
        int subproblemRes[] = new int [pointCount + 1];
        subproblemRes[0] = subproblemRes[1] = 1;
        for (int i = 2; i <= pointCount; i++) {
            subproblemRes[i] = 0;
            for (int j = 0; j < i; j++) {
                subproblemRes[i] += subproblemRes[j] * subproblemRes[i - j - 1];
            }
        }
        return subproblemRes[pointCount];
    }
}
