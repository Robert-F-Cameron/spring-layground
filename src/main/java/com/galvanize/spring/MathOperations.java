package com.galvanize.spring;

import java.security.PublicKey;
import java.util.Map;

public class MathOperations {
    private String operation;
    private Integer x;
    private Integer y;
    private Integer radius;
    private Integer width;
    private Integer height;
    private double result;


    public MathOperations(String operation, Integer x, Integer y, Integer radius, Integer width, Integer height) {
        this.operation = operation != null ? operation : "add";
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.width = width;
        this.height = height;
        setResult(x,y, width, height, radius);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(Integer x, Integer y, Integer width, Integer height, Integer radius) {
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
            case "area":
                findArea(width,height,radius);
        }
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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
        if (this.radius != null){
            return String.format("The %s of a circle pi %d^2 equals %s", this.operation, this.radius, this.result);
        } else if(this.operation.equals("area")){
            return String.format("The %s of a square with a width of %d and height of %d equals %s", this.operation, this.width, this.height, this.result);
        } else {
            return String.format("%s %s and %s equals %s", this.operation, this.x, this.y, this.result);
        }
    }
    public static String getVolumeString(Map<String, String> sideLengths) {
        int length = Integer.parseInt(sideLengths.get("length"));
        int width = Integer.parseInt(sideLengths.get("width"));
        int height = Integer.parseInt(sideLengths.get("height"));
        int volume = length * width * height;
        return String.format("The volume of a %dx%dx%d rectangle is %d", length, width, height, volume);
    }

    public static String getSumString(double[] values) {
        double sum = 0;
        StringBuilder valStr = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            double val = values[i];
            sum += val;
            valStr.append(val);
            if (i == values.length - 1) {
                valStr.append(" = ");
            } else {
                valStr.append(" + ");
            }
        }
        return String.format("%s%s", valStr.toString(), sum);
    }

    public void findArea(Integer width, Integer height, Integer radius){
        if(width != null && height != null){
            this.result = width*height;
        } else if(width==null &&height==null&&radius!=null){
            this.result=Math.PI*Math.pow(radius,2);
        }
    }
}
