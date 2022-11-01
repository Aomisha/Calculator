import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input){
        String result = null;
        String[] teil = input.split(" ");   //Записываем в массив все элеменеты с консоли после пробела
        int count = 0;                     //Счетчик для проверки знаков с консоли
        for (int i = 0; i < teil.length; i++) {
            count++;                                //Если count==1 значит это не мат операция, если больше 3, то тоже нам не подходит
        }
        if(count == 1){
            throw new RuntimeException("Не математическая операция");
        }   else if(count == 3){
            String operat = teil[1];
            if(isRom(teil[0])==isRom(teil[2])){         //Проверяем, в одном ли формате числа из консоли
                int firstNum;
                int secondNum;
                char op = operat.charAt(0); //
                boolean yorn = isRom(teil[0]);      //Проверяем римские ли цифры 
                if(yorn){                                   //если римские, то через метод конвертируем их в инт через метод
                    firstNum = convertRomToInt(teil[0]);
                    secondNum = convertRomToInt(teil[2]);
                } else{                                         //если арабские, то парсим без метода
                    if(isOneToTen(teil[0]) == isOneToTen(teil[2])){     //проверяем, является ли число от 1 до 10, если нет - ошибка
                        firstNum = Integer.parseInt(teil[0]);
                        secondNum = Integer.parseInt(teil[2]);
                    }   else {
                        throw new RuntimeException("Числа должны быть от 1 до 10!");
                    }
                }
                int resultat = 0;
                switch (op){
                    case '+':
                        resultat = firstNum+secondNum;
                        break;
                    case '-':
                        resultat = firstNum-secondNum;
                        break;
                    case '*':
                        resultat = firstNum*secondNum;
                        break;
                    case '/':
                        try {
                            resultat = firstNum/secondNum;
                        } catch (ArithmeticException e) {
                            System.out.println("Деление на ноль");
                            break;
                        }
                        break;
                    default:
                        System.out.println("Не правильная операция");
                }
                if(yorn){                       //Если римские, то выводим результат, переводя int в String, перед этим проверив, не является ли число 0, т.к в римских числах нет нуля
                    if(resultat < 0){
                        throw new RuntimeException("В римском счислении нет отрицательных чисел");
                    }
                    result = numToRom(resultat);
                } else{                                 //если арабские, то просто парсируем в String
                    result = Integer.toString(resultat);
                }

            }   else{
                throw new RuntimeException("Числа должны быть в одном формате, а так же от 1 до 10!");
            }
        } else{
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n" +
                    "\n");
        }
        return result;
    }

    static boolean isOneToTen(String num){      //Метод для проверки числа от 1 до 10
        if(num.equals("1")){
            return true;
        } else if(num.equals("2")){
            return true;
        }   else if(num.equals("3")){
            return true;
        }   else if(num.equals("4")){
            return true;
        }   else if(num.equals("5")){
            return true;
        }   else if(num.equals("6")){
            return true;
        }   else if(num.equals("7")){
            return true;
        }   else if(num.equals("8")){
            return true;
        }   else if(num.equals("9")){
            return true;
        }   else if(num.equals("10")){
            return true;
        }   else {
            return false;
        }
    }

    static int convertRomToInt(String num){             //Метод для конверта из римских чисел в арабские в тип int
        int number = 0;
        if(num.equals("I")){
            return number = 1;
        } else if(num.equals("II")){
            return number = 2;
        }   else if(num.equals("III")){
            return number = 3;
        }   else if(num.equals("IV")){
            return number = 4;
        }   else if(num.equals("V")){
            return number = 5;
        }   else if(num.equals("VI")){
            return number = 6;
        }   else if(num.equals("VII")){
            return number = 7;
        }   else if(num.equals("VIII")){
            return number = 8;
        }   else if(num.equals("IX")){
            return number = 9;
        }   else if(num.equals("X")){
            return number = 10;
        }
        return number;
    }

    static boolean isRom(String num){               //проверяем, является ли число римским
        if(num.equals("I")){
            return true;
        } else if(num.equals("II")){
            return true;
        }   else if(num.equals("III")){
            return true;
        }   else if(num.equals("IV")){
            return true;
        }   else if(num.equals("V")){
            return true;
        }   else if(num.equals("VI")){
            return true;
        }   else if(num.equals("VII")){
            return true;
        }   else if(num.equals("VIII")){
            return true;
        }   else if(num.equals("IX")){
            return true;
        }   else if(num.equals("X")){
            return true;
        }   else {
            return false;
        }
    }

    static int strToNum(String num){                //Метод для перевода числа из String в int 
        int number = Integer.parseInt(num);
        return number;
    }
    
    static String numToRom(int num){                                                                        //Метод для перевода конечного результата в римскую цифру
        String[] romNum = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        String answer = romNum[num];

        return answer;
    }

    static boolean numIndeticalOrNo(String check){                  //проверяем, являются ли числа одного формата
        boolean ans;
        if(check.equals("1") || check.equals("I")){
            return ans = true;
        }   else if(check.equals("2") || check.equals("II")){
            return ans = true;
        }   else if(check.equals("3") || check.equals("III")){
            return ans = true;
        }   else if(check.equals("4") || check.equals("IV")){
            return ans = true;
        }   else if(check.equals("5") || check.equals("V")){
            return ans = true;
        }   else if(check.equals("6") || check.equals("VI")){
            return ans = true;
        }   else if(check.equals("7") || check.equals("VII")){
            return ans = true;
        }   else if(check.equals("8") || check.equals("VIII")){
            return ans = true;
        }   else if(check.equals("9") || check.equals("IX")){
            return ans = true;
        }   else if(check.equals("10") || check.equals("X")){
            return ans = true;
        }   else{
            return ans = false;
        }
    }

}
