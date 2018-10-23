package ru.laz.tz.util;

public class Ruble {

    public enum Currency{
        RUBLE, CENT;
    }

    private long cent;

    public Ruble(long value, Ruble.Currency cur) {
        this.cent = cur.equals(Currency.CENT) ? value : value*100;
    }


    public long getCent() {
        return cent;
    }

    public void setCent(long cent) {
        this.cent = cent;
    }


    public long getRoubles() {
        return Math.round(cent/100.0f);
    }

    public int getLeftCents() {
        return (int)(cent%100);
    }

    @Override
    public String toString() {
        return getRoubles() + "." + getLeftCents();
    }

}
