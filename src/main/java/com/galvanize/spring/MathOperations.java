package com.galvanize.spring;

import java.util.Map;

public class MathOperations {
    private String operation;
    private Integer x;
    private Integer y;
    private Integer result;

    public MathOperations(String operation, Integer x, Integer y, Integer result) {
        this.operation = operation != null ? operation : "add";
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
            default: case "add":
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
        return String.format("%s %s and %s equals %s", this.operation, this.x, this.y, this.result);
    }
    public static String getVolumeString(Map<String, String> sideLengths) {
        int length = Integer.parseInt(sideLengths.get("length"));
        int width = Integer.parseInt(sideLengths.get("width"));
        int height = Integer.parseInt(sideLengths.get("height"));
        int volume = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);
    }

    public static String getSumString(int[] values) {
        int sum = 0;
        StringBuilder valStr = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int val = values[i];
            sum += val;
            valStr.append(val);
            if (i == values.length - 1) {
                valStr.append(" = ");
            } else {
                valStr.append(" + ");
            }
        }
        return String.format("%s%d", valStr.toString(), sum);
    }
}
