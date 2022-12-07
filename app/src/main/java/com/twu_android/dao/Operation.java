package com.twu_android.dao;

public class Operation {
    private final int id;
    private final double first_value;
    private final double second_value;
    private final String operation_name;
    private final double result;

    public Operation(int id, double first_value, double second_value, String operation_name, double result) {
        this.id = id;
        this.first_value = first_value;
        this.second_value = second_value;
        this.operation_name = operation_name;
        this.result = result;
    }


    public int getId() {
        return id;
    }

    public double getFirst_value() {
        return first_value;
    }

    public double getSecond_value() {
        return second_value;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public double getResult() {
        return result;
    }
}
