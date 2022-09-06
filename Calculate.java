package Kata;

import java.io.IOException;
import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) throws IOException {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "*", "/"};
        String[] regexActions = {"\\+", "-", "\\*", "/"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = sc.nextLine();

            int actionIndex = -1;
            for (int i = 0; i < actions.length; i++) {
                if (exp.contains(actions[i])) {
                    actionIndex = i;
                    break;
                }
            }

            //Если не нашли арифметическое действие, завершаем программу
            if (actionIndex == -1) {
                System.out.println("Неккоректное выражение");
                return;
            }


            String[] data = exp.split(regexActions[actionIndex]);
            if (data.length > 2){
                System.out.println("Только для двух чисел");
            }






            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;


                boolean isRoman = converter.isRoman(data[0]);
                if (isRoman) {
                    a = converter.romanToInt(data[0]);


                    if (a < 1 || a > 10) {
                        throw new IOException("число должно быть в диапазоне от 1 до 10");
                    }
                    b = converter.romanToInt(data[1]);
                    if (b < 1 || b > 10){
                        throw new IOException("число должно быть в диапазоне от 1 до 10");
                    }





                }


                else {
                    a = Integer.parseInt(data[0]);
                    if (a < 1 || a > 10){
                        throw new IOException("число должно быть в диапазоне от 1 до 10");
                    }
                    b = Integer.parseInt(data[1]);
                    if (b < 1 || b > 10){
                        throw new IOException("число должно быть в диапазоне от 1 до 10");
                    }

                }






                    int res;
                    switch (actions[actionIndex]) {
                        case "+":
                            res = a + b;
                            break;
                        case "-":
                            res = a - b;
                            break;
                        case "*":
                            res = a * b;
                            break;
                        default:
                            res = a / b;
                            break;
                    }
                    // X -- 10
                    if (isRoman) {
                        // если числа были римские, возвращаем результат в арабском числе
                        System.out.println(converter.intToRoman(res));
                    } else {
                        //если числа были арабские, возвращаем результат в арабском числе
                        System.out.println(res);
                    }
                } else{
                    System.out.println("Числа должны быть в одном формате");
                }
            }
        }



