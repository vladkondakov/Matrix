package com.company;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input n:");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Input vector:");
        // Вектор задаётся из значений множества {0,1} как строка без пробелов и других символов между его компонентами
        String v = sc.nextLine();


        double[][] matrix1 = new double[n][n];
        double[][] matrix2 = new double[n][n];
        byte[] vector = new byte[n];
        double[] s1 = new double[n];
        double[] s2 = new double[n];
        double[] s3 = new double[n];

        for (int i = 0; i < n; i++) {
            vector[i] = (byte) Character.getNumericValue(v.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = Math.cos(2  * Math.PI / n * (i+1) * (j+1));
                matrix2[i][j] = Math.sin(2  * Math.PI / n * (i+1) * (j+1));
                s1[i] = s1[i] + matrix1[i][j] * vector[j];
                s2[i] = s2[i] + matrix2[i][j] * vector[j];
            }
        }

        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        String temp;

        for (int i = 0; i < n; i++) {
            temp = (df.format(s1[i] * s1[i] + s2[i] * s2[i])).replace(",", ".");
            s3[i] = Double.parseDouble(temp);
        }
        //Выводим вектор в консоль
        System.out.println();
        System.out.println("The result of operations is");
        System.out.print("(");
        for (int i = 0; i < n-1; i++) {
            System.out.print(s3[i] + "; ");
        }
        System.out.print(s3[n-1]  + ")");
    }
}
