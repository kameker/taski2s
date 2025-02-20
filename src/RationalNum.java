public class RationalNum {
    private int numerator;
    private int denominator;

    public RationalNum(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }

    public String toString() {
        return numerator == denominator ? "1" : numerator == -denominator ? "-1" : numerator + "/" + denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void add(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        int[] shortedNum = getShortedNum(a * b2 + a2 * b, b * b2);
        this.numerator = shortedNum[0];
        this.denominator = shortedNum[1];
    }

    public void sub(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        int[] shortedNum = getShortedNum(a * b2 - a2 * b, b * b2);
        this.numerator = shortedNum[0];
        this.denominator = shortedNum[1];
    }

    public void mul(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        int[] shortedNum = getShortedNum(a * a2, b * b2);
        this.numerator = shortedNum[0];
        this.denominator = shortedNum[1];
    }

    public void div(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        int[] shortedNum = getShortedNum(a * b2, b * a2);
        this.numerator = shortedNum[0];
        this.denominator = shortedNum[1];
    }

    public boolean isEqual(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        return a == b && a2 == b2;
    }

    public boolean isGreaterThan(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        return a * b2 > a2 * b;
    }

    public boolean isLessThan(RationalNum num2) {
        int a = this.numerator;
        int b = this.denominator;
        int a2 = num2.getNumerator();
        int b2 = num2.getDenominator();
        return a * b2 < a2 * b;
    }

    public int[] getShortedNum(int a, int b) {
        int newA = Math.abs(a), newB = Math.abs(b);
        for (int i = (int) (Math.sqrt(Math.max(newA, newB)) + 1); i > 1; i--) {
            if (i > Math.min(newA, newB)) break;
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        return new int[]{a, b};
    }
}