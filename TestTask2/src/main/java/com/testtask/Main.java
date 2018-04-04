package com.testtask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static String showQuery = "select * from students_table";
    private static String addQuery =  "insert into students_table(name,surname,patronymic,date_of_birth,gr) values (?,?,?,?,?)";
    private static String DELETE_QUERY = "delete from students_table where id=?";
    private static String datePattern = "yyyy.MM.dd";
    private static HashMap<Integer,Student> students = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.out.println("Commands:\nADD = add student\nDELETE = Delete student by id\nSHOW = show all students");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        while (!answer.equals("EXIT")) {
            System.out.println("!!!!!!!!!ENTER COMAND!!!!!!!!!! ");
            answer = reader.readLine();
            if (answer.equals("SHOW")) {
                try {
                    DBWorker worker = new DBWorker();
                    Statement statement = worker.getConnection().createStatement();
                    ResultSet result = statement.executeQuery(showQuery);

                    while (result.next()) {
                        int id = result.getInt(1);
                        students.put(id, new Student(result.getInt(1), result.getString(2),
                                result.getString(3), result.getString(4), result.getString(5), result.getString(6)));
                    }
                    for (Map.Entry<Integer, Student> entry : students.entrySet()) {
                        int key = entry.getKey();
                        Student value = entry.getValue();
                        System.out.println("id: " + value.getId() + "; "
                                + "Name: " + value.getName() + "; "
                                + "Surname: " + value.getSurname() + "; "
                                + "Patronymic: " + value.getPatronymic() + "; "
                                + "Date of birth: " + value.getDate() + "; "
                                + "Group: " + value.getGroup());
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (answer.equals("ADD")) {
                try {
                    System.out.print("Enter student name: ");
                    String name = reader.readLine();
                    System.out.print("Enter student surname: ");
                    String surname = reader.readLine();
                    System.out.print("Enter student patronymic: ");
                    String patronymic = reader.readLine();
                    System.out.print("Enter student date of birth (format YYYY.MM.DD): ");
                    String dat = reader.readLine();
                    System.out.print("Enter student group: ");
                    String group = reader.readLine();

                    DBWorker worker = new DBWorker();
                    PreparedStatement statement = worker.getConnection().prepareStatement(addQuery);
                    statement.setString(1, name);
                    statement.setString(2, surname);
                    statement.setString(3, patronymic);
                    statement.setString(4, dat);
                    statement.setString(5, group);
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (answer.equals("DELETE")) {
                System.out.println("Enter student id");
                int id = Integer.parseInt(reader.readLine());
                try {
                    DBWorker worker = new DBWorker();
                    PreparedStatement statement = worker.getConnection().prepareStatement(DELETE_QUERY);
                    statement.setInt(1, id);
                    statement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        reader.close();
    }
}
