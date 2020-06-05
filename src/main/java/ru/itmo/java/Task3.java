package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }
        int lastElement = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = lastElement;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int value : inputArray) {
            if (value > firstMax) {
                firstMax = value;
            } else if (value > secondMax) {
                secondMax = value;
            }
        }
        return firstMax * secondMax;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.toLowerCase().charAt(i) == 'a' || input.toLowerCase().charAt(i) == 'b') {
                count++;
            }
        }
        return count * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }
        result.append(input.charAt(input.length() - 1));
        result.append(count);

        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < one.length(); i++) {
            count[one.charAt(i)]++;
        }
        for (int i = 0; i < two.length(); i++) {
            count[two.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int[] counter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)]++;
        }
        for (int value : counter) {
            if (value > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[][]{{}, {}};
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }

        if (separator == null) {
            separator = ' ';
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputStrings.length - 1; i++) {
            result.append(inputStrings[i]).append(separator);
        }
        result.append(inputStrings[inputStrings.length - 1]);

        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < inputStrings.length; i++) {
            if (inputStrings[i].startsWith(prefix)) {
                count++;
            }
        }

        return count;
    }
}
