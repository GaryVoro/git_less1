import java.util.Arrays;
import java.util.Collections;
/*
В массиве хранится n явно заданных текстовых строк. Создать метод:
- выводящий содержимое массива в строку через пробел;
- сортирующий массив в обратном порядке (без учета регистра) от z до a;
- сортирующий массив по количеству слов в строке (слова разделены пробелами).
Программа должна вывести строки в начальном и отсортированном порядке.
 */
public class HomeWork6_1 {
    public static void main(String[] args) {

        String[] arrStringMy = {"Нивы сжаты,", "рощи голы.", "За окном туман и сырость,", "Колесом за сини горы", "Солнце красное скатилось"};

        printStr(arrStringMy);

        String[] arrStringSortedReverse = sortedStringsReverse(arrStringMy);

        String [] arrWordsSortMy = sortedWordsArray(arrStringMy);

        Integer[] quantWordsMy = new Integer[arrStringMy.length];

        String[] strSortToWords = sortedStringToWords(arrStringMy, quantWordsMy);

        System.out.println("arrStringMy:" + Arrays.toString(arrStringMy));
          System.out.println("arrStringSortedReverse:" + Arrays.toString(arrStringSortedReverse));
            System.out.println("arrWordsSortMy:" + Arrays.toString(arrWordsSortMy));
                System.out.println("strSortToWords:" + Arrays.toString(strSortToWords));

    }

    public static void printStr(String[] arrString){
        String oneStr = "";
        for (String item: arrString)
        {
            oneStr = oneStr + item + " ";
        }
        System.out.println(":" + oneStr);
    }

    public static String[] sortedStringsReverse(String[] arrString) {
        String[] arrStringSortedReverse = new String[arrString.length];
        System.arraycopy(arrString, 0, arrStringSortedReverse, 0, arrString.length);
        Arrays.sort(arrStringSortedReverse, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        return(arrStringSortedReverse);
    }

    public static String[] sortedWordsArray(String[] arrString) {
        int index = 0;
        String [] arrWordsSortMy = new String[arrString.length];
        String [] arrWordsSort = new String[]{};
        for (String item: arrString)
        {
            arrWordsSort = item.split(" ");;
            Arrays.sort(arrWordsSort, String.CASE_INSENSITIVE_ORDER); //Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)
            arrWordsSortMy[index] = String.join(" ", arrWordsSort);
            index++;
        }
        return(arrWordsSortMy);
    }

    public static String[] sortedStringToWords(String[] arrToSort, Integer[] quantWM){
        //количество слов в строке
        int pos = 0;
        for (String item: arrToSort)
        {
            int count = 0;
            boolean isWord = false;
            for (char c : item.toCharArray()) {
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= 'а' && c <= 'я' || c >= 'А' && c <= 'Я') {
                    if (!isWord) {
                        isWord = true;
                        count++;
                    }
                }else
                {
                    isWord = false;
                }
            }
            quantWM[pos]=count;
            pos++;
        }
        //запомнить позиции подстрок
        int[] position = new int [quantWM.length];
        for (int i = 0; i < quantWM.length; i++) {
            position[i]=i;
        }
        //сортировать значения количество слов в строке, старые позиции подстрок перемещаются вместе со значением количества слов в строке
        int indPos = 0;
        boolean isSorted = false;
        int bufCount = 0;
        int bufPos = 0;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < quantWM.length-1; i++) {
                if(quantWM[i] > quantWM[i+1]){
                    isSorted = false;
                    bufCount = quantWM[i];
                    bufPos = position[i];
                    quantWM[i] = quantWM[i+1];
                    position[i] = position[i+1];
                    quantWM[i+1] = bufCount;
                    position[i+1] = bufPos;
                }
            }

        }
        String[] strSortToWords = new String[arrToSort.length];
        int k = 0;
        for (int i = 0; i < arrToSort.length; i++) {
            strSortToWords[i] = arrToSort[position[i]];
        }
        return (strSortToWords);
    }
}