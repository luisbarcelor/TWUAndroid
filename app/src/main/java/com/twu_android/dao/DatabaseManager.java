package com.twu_android.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseManager {
    public static ArrayList<Operation> readOperations() {
        ArrayList<Operation> operationList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculadora");
             PreparedStatement statement = conn.prepareStatement("SELECT * FROM operaciones");
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                double first_value = rs.getDouble("primer_valor");
                double second_value = rs.getDouble("segundo_valor");
                String operation_name = rs.getString("operacion");
                double result = rs.getDouble("resultado");

                operationList.add(new Operation(id, first_value, second_value, operation_name, result));
            }

        } catch (SQLException ex) {
            System.out.println("ERROR WHILE READING OPERATIONS");
        }

        return operationList;
    }

    public static void insertOperation(double val1, double val2, String operation, double result) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculadora");
             PreparedStatement statement = conn.prepareStatement("INSERT INTO operaciones " +
                     "values (null, ?, ?, ?, ?)")) {

            statement.setDouble(1, val1);
            statement.setDouble(2, val2);
            statement.setString(3, operation);
            statement.setDouble(4, result);

            statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR WHILE INSERTING OPERATION");
        }
    }

    public static Operation getLastOperation(ArrayList<Operation> operationList) {
        return operationList.get(operationList.size() - 1);
    }
}
