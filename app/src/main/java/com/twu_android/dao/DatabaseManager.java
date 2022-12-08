package com.twu_android.dao;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseManager {
    public static ArrayList<Operation> readOperations() {
        ArrayList<Operation> operationsList = new ArrayList<>();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Background work here
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306/calculadora?" +
                "useSSL=false&user=luisbarcelo&password=030305");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM operaciones;");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double first_value = rs.getDouble("primer_valor");
                double second_value = rs.getDouble("segundo_valor");
                String operation_name = rs.getString("operacion");
                double result = rs.getDouble("resultado");

                operationsList.add(new Operation(id, first_value, second_value, operation_name, result));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR WHILE READING OPERATIONS");
        }

        return operationsList;
    }

    public static void insertOperation(double val1, double val2, String operation, double result) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.139:3306/calculadora?" +
                "useSSL=false&user=luisbarcelo&password=030305");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO operaciones " +
                     "values (null, ?, ?, ?, ?);")) {

            statement.setDouble(1, val1);
            statement.setDouble(2, val2);
            statement.setString(3, operation);
            statement.setDouble(4, result);

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR WHILE INSERTING OPERATION");
            ex.printStackTrace();
        }
    }

    public static Operation getLastOperation(ArrayList<Operation> operationList) {
        return operationList.get(operationList.size() - 1);
    }
}
