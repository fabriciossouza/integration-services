package br.com.semcodar.integration.model;

public class Calculator {
    private Integer n1;
    private Integer n2;
    private Integer total;

    public Calculator() {
    }

    public Calculator(Integer n1, Integer n2, Integer total) {
        this.n1 = n1;
        this.n2 = n2;
        this.total = total;
    }

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
