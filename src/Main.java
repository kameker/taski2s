public class Main {
    public static int roundToNearestMultipleOf200(int number) {
        int remainder = number % 200;
        return remainder < 200 ? number - remainder : number + (200 - remainder);
    }
    public static void main(String[] args) {
        System.out.println(roundToNearestMultipleOf200(1500));
        System.out.println(roundToNearestMultipleOf200(1560));
        System.out.println(roundToNearestMultipleOf200(1700));
        System.out.println(roundToNearestMultipleOf200(1701));
        System.out.println(roundToNearestMultipleOf200(1));
        System.out.println(roundToNearestMultipleOf200(15));
        System.out.println(roundToNearestMultipleOf200(-1499));
    }
}