public class MyUtils {
    public static String getSpace(int k){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++){
            result.append(" ");
        }
        return result.toString();
    }
    public static String getLine(int  k){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++){
            result.append("-");
        }
        return result.toString();
    }
    public static int getLengthofNum(int number) {
        if (number == 0) return 1; // Обработка числа 0
        return (int) Math.log10(Math.abs(number)) + 1;
    }
}
