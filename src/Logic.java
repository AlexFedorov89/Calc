import javax.swing.*;

public class Logic {
    static boolean operationIntroduced = false;

    static int currentParametr = 1;
    static private String operation = "";
    static private String a = "0", b = "0";

    // Метод установки аргументов.
    public static void setCurrentArgument(String _parametr) {

        if (currentParametr == 1) {
            a += _parametr;
        } else {
            b += _parametr;
        }
    }

    public static boolean isFullArgument() {
        boolean result = false;

        int argLength = (currentParametr == 1)?a.length():b.length();
        if (argLength >= 15) {

            result = true;
        }

        return result;
    }

    // Метод установки значения операции.
    public static void setOperation(String _operation) {
        // Установить знак операции.
        operation = _operation;
        // Установить аргумент для заполнения.
        currentParametr = 2;
        // Очистить второй аргумент.
        b = "0";
        operationIntroduced = true;
    }

    // Метод очистки данных калькулятора.
    public static void cleanAllParametrs() {
        a = "0";
        b = "0";
        operation = "";
        currentParametr = 1;
        operationIntroduced = false;
    }

    // Функция вычисления операций.
    public static String deem() {
        String result = "";
        double arg1 = Double.parseDouble(a), arg2 = Double.parseDouble(b);


        switch (operation) {
            case ("Div"): {
                if (arg2 == 0) {
                    cleanAllParametrs();
                    return "На ноль делить нельзя!";
                }
                result = getDiv(arg1, arg2);

                break;
            }
            case ("Plus"): {
                result = getPlus(arg1, arg2);

                break;
            }
            case ("Minus"): {
                result = getMinus(arg1, arg2);

                break;
            }

            case ("Multiply"): {
                result = getMultiply(arg1, arg2);

                break;
            }
            case ("Degree"): {
                result = getDegree(arg1, arg2);

                break;
            }
        }


        // Поместить результат в первый аргумент.
        a = result;
        // Установить счетчик заполнения аргумента.
        currentParametr = 1;
        // Сбросить флаг введеной операции.
        operationIntroduced = false;

        return result;
    }

    private static String getDegree(double arg1, double arg2) {
        String result   = "";

        double dResult  = arg1;

        // Цикл возведения в степень.
        for(int i = 1; i < arg2; i ++){
            dResult = dResult * arg1;
        }

        // Преобразовать в строку.
        result +=dResult;

        return result;
    }

    // Функция сложения.
    private static String getPlus(double arg1, double arg2) {
        String result = "";

        result += (arg1 + arg2);

        return result;
    }

    // Функция деления.
    private static String getDiv(double arg1, double arg2) {
        String result = "";

        result += (arg1 / arg2);

        return result;
    }

    // Функция вычитания.
    private static String getMinus(double arg1, double arg2) {
        String result = "";

        result += (arg1 - arg2);

        return result;
    }

    // Функция умножения.
    private static String getMultiply(double arg1, double arg2) {
        String result = "";

        result += (arg1 * arg2);

        return result;
    }
}


