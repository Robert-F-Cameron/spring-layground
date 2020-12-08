package com.galvanize.spring;

public class MathOperations {
    private String operation;
    private Integer x;
    private Integer y;
    private Integer result;

    public MathOperations(String operation, Integer x, Integer y, Integer result) {
        this.operation = operation;
        this.x = x;
        this.y = y;
        setResult(x,y);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer x, Integer y) {
        switch (this.operation) {
            case "add":
                this.result = Math.addExact(x, y);
                break;
            case "multiply":
                this.result = Math.multiplyExact(x, y);
                break;
            case "subtract":
                this.result = Math.subtractExact(x, y);
                break;
            case "divide":
                this.result = Math.floorDiv(x, y);
                break;
            default: this.result = 0;
                break;
        }
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s %s", this.operation, this.x, this.y, this.result);
    }

}
