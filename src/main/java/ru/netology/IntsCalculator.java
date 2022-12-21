package ru.netology;

public class IntsCalculator implements Ints {

    protected final Calculator target;

    public IntsCalculator() {
        this.target = new Calculator();
    }


    @Override
    public int sum(int arg0, int arg1) {
        double summ = putArgue(arg0, arg1)
                .calculate(Calculator.Operation.SUM)
                .result();
        if (checkInteger(summ)) return (int) summ;
        return 0;
    }

    @Override
    public int mult(int arg0, int arg1) {
        double mlt = putArgue(arg0, arg1)
                .calculate(Calculator.Operation.MULT)
                .result();
        if (checkInteger(mlt)) return (int) mlt;
        return 0;
    }

    @Override
    public int pow(int a, int b) {
        double pw = putArgue(a, b)
                .calculate(Calculator.Operation.POW)
                .result();
        if (checkInteger(pw)) return (int) pw;
        return 0;
    }

    private Calculator.Formula putArgue(int a, int b) {
        return target.newFormula()
                .addOperand((double) a)
                .addOperand((double) b);
    }

    private boolean checkInteger(double a) {
        if ((int) a == a) {
            return true;
        } else {
            throw new IllegalStateException("Integer overflow");
        }
    }
}
