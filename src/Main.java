public class Main {
    public static void main(String[] args) {
        RationalNum num1 = new RationalNum(-7, 9);
        RationalNum num2 = new RationalNum(-2, 9);
        num1.sub(num2);
        System.out.println(num1);
    }
}