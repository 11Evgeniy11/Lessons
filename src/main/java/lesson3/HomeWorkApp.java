package lesson3;

import java.util.Arrays;

public class HomeWorkApp {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        exercise1();
        System.out.println("Задание 2");
        exercise2();
        System.out.println("Задание 3");
        exercise3();
        System.out.println("Задание 4");
        exercise4();
        System.out.println("Задание 5");
        System.out.println(Arrays.toString(exercise5(5, 6)));

    }

    private static void exercise1() {
        System.out.println("Исходный массив");
        int[] arr1 = {0, 1, 0, 0, 1};
        System.out.println(Arrays.toString(arr1));
        System.out.println("Массив после замены");
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 1) {
                arr1[i] = 0;
            } else {
                arr1[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }


    private static void exercise2() {
        int[] arr2 = new int[100];
        for (int i = 0; i < 100; i++) {
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));
    }

    private static void exercise3() {
        System.out.println("Исходный массив");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        System.out.println("Массив после замены");
        for (int i = 0; i < 12; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
                }
            }
        System.out.println(Arrays.toString(arr3));
    }

    private static void exercise4() {
        int[][] table1 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            table1[i][i] = 1;
            table1[i][10 - i - 1] = 1;
        }
        for (int i = 0; i < 10; i++)
            System.out.println(Arrays.toString(table1[i]));
    }

    public static int[] exercise5 (int len, int initialValue){
        int arr4[] = new int[len];
        for (int i = 0; i < arr4.length; i++){
            arr4[i] = initialValue;
        }
        return arr4;
        }



}



