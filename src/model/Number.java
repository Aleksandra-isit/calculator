package model;

public class Number {
    private String num;
    public Number(String num) {
        this.num = num;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.format("%s", num);
    }
}
