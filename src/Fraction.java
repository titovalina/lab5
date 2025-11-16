public class Fraction {
    private int numerator;
    private int denominator;
    private Double cachedValue = null;

    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) throw new IllegalArgumentException("Знаменатель должен быть положительным!");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedValue = null;
    }

    public void setDenominator(int denominator) {
        if (denominator <= 0) throw new IllegalArgumentException("Знаменатель должен быть положительным!");
        this.denominator = denominator;
        cachedValue = null;
    }

    public double toDouble() {
        if (cachedValue == null) {
            cachedValue = (double) numerator / denominator;
        }
        return cachedValue;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }
}
