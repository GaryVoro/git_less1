/*
НОД
Написать рекурсивный статический метод нахождения
наибольшего общего делителя двух целых чисел.
Разворот числа
С клавиатуры вводится число n, десятичная запись кото-
рого не содержит нулей. Получите число, записанное теми
же цифрами, но в противоположном порядке. При решении
этой задачи разрешается только рекурсия и целочисленная
арифметика. Метод должен возвращать целое число, явля-
ющееся результатом работы программы, выводить число по
одной цифре нельзя.
Ввод: 179
Вывод: 971
*/
import java.util.Scanner;

public class HomeWork6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nod;
        System.out.print("Firs number : ");
        int numberOne = sc.nextInt();
        System.out.print("Second number : ");
        int numberTwo = sc.nextInt();
        System.out.print("Введите десятичное число не содержащее 0 : ");
        Integer numberThree = sc.nextInt();
        StringBuilder strThree = new StringBuilder();
        strThree.append(numberThree);

        if (strThree.indexOf("0")>0){
            System.out.print("В числе содержится 0. Он будет заменен на 1.");
            strThree.setCharAt(strThree.indexOf("0"), '1');
        }
        numberThree = reverseInteger(strThree, strThree.length()-1, 0);
        System.out.println(numberThree);

        nod = getRecursionNod(numberOne, numberTwo);
        System.out.println(nod);


    }
    public static int getRecursionNod(int numOne, int numTwo) {
        if (numTwo == 0) {
            return numOne;
        }
       // System.out.println(numOne + " ___ " + numTwo);
        return getRecursionNod(numTwo, numOne % numTwo);
    }
    public static int reverseInteger(StringBuilder str, int len, int counterIntput){
        if (len>counterIntput){
            char chSave;
            chSave = str.charAt(counterIntput);
            str.setCharAt(counterIntput, str.charAt(len));
            str.setCharAt(len, chSave);
            len = len--;
            counterIntput++;
            reverseInteger(str, len, counterIntput);
        }
        return Integer.parseInt(str.toString());
    }
}
