public class Main {
    public static void main(String[] args) {
        RationalNum num1 = new RationalNum(8793198, 489);
        RationalNum num2 = new RationalNum(165, 10);
        num1.add(num2);
        num1.sub(num2);
        System.out.println(num1.toString());
    }
}