package ru.pasha.pt.lab2;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

@XmlRootElement
public class State {
    private int x;
    private int y;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public State() {}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("{x = %d, y = %d}", x, y);
    }

    State multiply(int a){
        BigInteger xValue = BigInteger.valueOf(x);
        BigInteger yValue = BigInteger.valueOf(y);
        BigInteger aValue = BigInteger.valueOf(a);

        x = xValue.multiply(aValue).intValueExact();
        y = yValue.multiply(aValue).intValueExact();
        return this;
    }

    State add(int a, int b){
        BigInteger xValue = BigInteger.valueOf(x);
        BigInteger yValue = BigInteger.valueOf(y);
        BigInteger aValue = BigInteger.valueOf(a);
        BigInteger bValue = BigInteger.valueOf(b);

        x = xValue.add(aValue).intValueExact();
        y = yValue.add(bValue).intValueExact();
        return this;
    }
}
