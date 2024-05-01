package edu.ufp.inf.lp2.p06_gui_javafx.calc;

import java.math.BigDecimal;

public class Calculator {

    private BigDecimal valueInMem;

    public Calculator() {
        this.valueInMem = new BigDecimal(0.0);
    }

    protected enum Op {NOOP, SUM, SUBTRACT, MULTIPLY, DIVIDE}

    public Double getValueInMem() {
        return this.valueInMem.doubleValue();
    }

    public void resetCalc() {
        this.valueInMem = new BigDecimal(0.0);
    }

    public void setValueInMem(Double value) {
        this.valueInMem = new BigDecimal(value);
    }


    public Double makeOperation(Op operation, Double number) {
        switch (operation) {
            case SUM:
                sum(number);
                break;
            case SUBTRACT:
                subtract(number);
                break;
            case MULTIPLY:
                multiply(number);
                break;
            case DIVIDE:
                divide(number);
        }
        return getValueInMem();
    }

    private void sum(Double number) {
        setValueInMem(getValueInMem() + number);
    }

    private void subtract(Double number) {
        setValueInMem(getValueInMem() - number);
    }

    private void multiply(Double number) {
        setValueInMem(getValueInMem() * number);
    }

    private void divide(Double number) {
        if (number == 0) {
            System.out.println("erro a dividir por 0");
        } else {
            setValueInMem(getValueInMem() / number);
        }
    }
}