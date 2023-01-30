/*
Заполнить массив размерности n случайными циф-
рами от 0 до 33. Найти элемент массива, который делится
без остатка на значение элемента слева и значение элемен-
та справа. Вывести на консоль значения исходного массива.
Вывести индекс найденного элемента, если такой не найден,
вывести -1. n – задается с клавиатуры.
*/

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork5_2 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int lengthArr = 0;

        do {
            System.out.print("Ведите длину массива : ");
            if (scnr.hasNextInt()) lengthArr = scnr.nextInt();
            else {
                scnr.next();
                System.out.println("Извините, вы ввели не корректный размер массива. Попробуйте снова!");                            }
        } while (lengthArr == 0);
/**/
        int[] arrayToExploerer = new int[lengthArr];
        for (int index = 0; index < arrayToExploerer.length; index++) {
            while (true) {
                System.out.printf("Введите число  № %s (от 1 до 33): ", index + 1);

                if (scnr.hasNextInt()) {
                   arrayToExploerer[index] = scnr.nextInt();
                   if (arrayToExploerer[index] > 0 && arrayToExploerer[index] <= 33) {
                        break;
                   } else {
                    System.out.println("Число не соответствует указанному диапазону. Попробуйте еще раз.");
                   }
                } else {
                    scnr.next();
                    System.out.println("Извините, вы ввели не корректное значение. Попробуйте снова!");
                }
            }

        }

        int findIndex = -1;
        for (int index = 1; index < arrayToExploerer.length; index++) {
            if ((arrayToExploerer[index] % arrayToExploerer[index-1]==0) && (arrayToExploerer[index] % arrayToExploerer[index+1]==0)){
                findIndex = index;
                break;
            }
        }

        System.out.printf("%s %n", Arrays.toString(arrayToExploerer));
        if (findIndex > 0){
            System.out.println("Индекс искомого элемента: " + findIndex);
        } else {
            System.out.println("Заданный элемент не обнаружен: " + findIndex);
        }
    }
}
