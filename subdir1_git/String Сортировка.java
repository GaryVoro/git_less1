      ������������� ���������� ������ � ������
char a[] = { �g�, �e�, �e�, �k�, �s�, �f�, �o�, �r�, �g�, �e�, �e�, �k�, �s�}
String str = new String(a);
str = String.valueOf(a);


String[] text = { "a", "b", "c", "d", "a" };
for (int A = 0; A < text.length; A++) {
  for (int B = 0; B < text.length; B++) {
    if (A != B && text[A].equals(text[B])) {
         System.out.println("Repeated word:" + text[A]);
    }
  }
}
      ���������� ������ �� �� ����������� � Java
      
import java.util.Arrays;

public class Test
{
    public static void main(String[] args)
    {
        String original = "edcba";
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);
    }
}
      
��� ������ ������������� �� � ������ ��������, ������������� �� � ������� Arrays.sort � ������������� ������� � ������.
String test= "edcba";
char[] ar = test.toCharArray();
Arrays.sort(ar);
String sorted = String.valueOf(ar);
      
      
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class Test
{
  public static void main(String[] args)
  {
    Collator collator = Collator.getInstance(new Locale("fr", "FR"));
    String original = "?DedCBcbA?a";
    String[] split = original.split("");
    Arrays.sort(split, collator);
    String sorted = "";
    for (int i = 0; i < split.length; i++)
    {
      sorted += split[i];
    }
    System.out.println(sorted); // "aA?bBcCdDe?"
  }
}
      
      
������������� � ������ ��������?�������������?�������������� ������� � ������:
String s = "edcba";
char[] c = s.toCharArray();        // convert to array of chars 
java.util.Arrays.sort(c);          // sort
String newString = new String(c);  // convert back to String
System.out.println(newString);     // "abcde"
      
��������� :
1. ������� ������������ ������ � ������ ��������
2. ����� ������������ ������ ��������
3. ������������ ������ �������� � ������
4. �������� ������
�������� ����:
    String input = "world";
    char[] arr = input.toCharArray();
    Arrays.sort(arr);
    String sorted = new String(arr);
    System.out.println(sorted);
      
      

������������� ������ � ������� ����c��� ����� toLowerCase()
      
      
       Str.toLowerCase()
       
����� split � Java: ����� ������ �� �����
public class Main {
    public static void main(String[] args) {
        String str = "I love Java";
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
         }
		 
}		
**************************************************************************
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
� ������� �������� n ���� �������� ��������� �����. ������� �����:
- ��������� ���������� ������� � ������ ����� ������;
- ����������� ������ � �������� ������� (��� ����� ��������) �� z �� a;
- ����������� ������ �� ���������� ���� � ������ (����� ��������� ���������).
��������� ������ ������� ������ � ��������� � ��������������� �������.
 */
public class HomeWork6_1 {
    public static void main(String[] args) {

        String[] arrStringMy = {"���� �����,", "���� ����.", "�� ����� ����� � �������,", "������� �� ���� ����", "������ ������� ���������"};
        String oneStr = "";// Arrays.toString(arrWords);

        for (String item: arrStringMy)
        {
            oneStr = oneStr + item + "_";
        }

        String[] arrStringSortedReverse = new String[arrStringMy.length];
        System.arraycopy(arrStringMy, 0, arrStringSortedReverse, 0, arrStringMy.length);
        Arrays.sort(arrStringSortedReverse, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        //List lst1 = Arrays.asList(arrWords);
        //Collections.sort(lst1, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        int index = 0;
        String [] arrWordsSortMy = new String[arrStringMy.length];
        String [] arrWordsSort = new String[]{};
        for (String item: arrStringMy)
        {
            arrWordsSort = item.split(" ");;
            Arrays.sort(arrWordsSort, String.CASE_INSENSITIVE_ORDER); //Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER)
            //arrWordsSortMy[index] = Arrays.toString(arrWordsSort);
            arrWordsSortMy[index] = String.join(" ", arrWordsSort);
            //arrWordsSortMy[index] = Arrays.toString(arrWordsSort);
            index++;
        }
        System.out.println("arrStringMy: " + Arrays.toString(arrStringMy));
          System.out.println(Arrays.toString(arrStringSortedReverse));
            System.out.println(Arrays.toString(arrWordsSortMy));

        int i = 0;


    }
}

***************************************************************************
