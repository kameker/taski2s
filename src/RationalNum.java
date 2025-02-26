public class RationalNum {
    private int numerator;
    private int denominator;

    public RationalNum(int a, int b) {
        this.numerator = a;
        this.denominator = b;
    }

    public String toString() {
        String result = "";
        if (this.numerator % this.denominator == 0) {
            return "" + this.numerator / this.denominator;
        } else {
            if(this.numerator > this.denominator) {
                result += this.numerator + "\n";
                result += MyUtils.getLine(MyUtils.getLengthofNum(this.numerator)) + "\n";
                result += MyUtils.getSpace(MyUtils.getLengthofNum(this.numerator) / 2 - (this.numerator % 2));
                result += this.denominator;
            }
            else{
                result += MyUtils.getSpace(MyUtils.getLengthofNum(this.denominator) / 2 - (this.denominator % 2));
                result += this.numerator + "\n";
                result += MyUtils.getLine(MyUtils.getLengthofNum(this.denominator)) + "\n";
                result += this.denominator;
            }
            return result;
        }
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
        for (int i = Math.min(newA, newB); i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
            }
        }
        return new int[]{a, b};
    }
}