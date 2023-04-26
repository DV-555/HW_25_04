package Lesson_29_25_04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HW_25_04_new {

  private static final int RADIX = 2;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
    int number = Integer.parseInt(br.readLine());

    FileWriter outputFileWriter = new FileWriter("res/output.txt");
    outputFileWriter.write(decToBin(number) + "\n");
    outputFileWriter.close();
  }
  public static String decToBin(int number) {

    boolean isNegative = number < 0;
    if (isNegative) {
      number = Math.abs(number);                // для целей деления и перебора чисел убрали знак
    }
    if (number == 0) {                          // вывод знака нуль, в случае input 0
      return "0";
    }
    StringBuilder binStr = new StringBuilder(); // Создание и провозглашение пустой строки

    while (number != 0) {                       // До тех пор, пока число отлично от нуля
      binStr.insert(0, number % RADIX);  // подтягиваем остаток от в строку и склеиваем
      number /= RADIX;                          // уменьшаем целое число в два раза
    }
    if (isNegative) {
      binStr.insert(0, "-");
    }
    return binStr.toString();                   // возвращаем строку
  }
}





