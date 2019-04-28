package web_app.Database_controller;
import web_app.Database_controller.QueryConstant;
import web_app.controller.Person;

import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;
public class QueryDB {

    private static String url = "jdbc:postgresql://localhost:5432/mybd";
    private static String username = "postgres";
    private static String password = "1111";

    public static ArrayList<Person> select() {
        ArrayList<Person> persons = new ArrayList<>();

        try{
            Class.forName("org.postgresql.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(QueryConstant.SELECT_ALL);
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String middlename = resultSet.getString(3);
                    String firstname = resultSet.getString(2);
                    String lastname = resultSet.getString(4);
                    String age = resultSet.getString(5);
                    String gender =resultSet.getString(6);
                    Person person = new Person(id,firstname,middlename,lastname,age,gender);
                    persons.add(person);
                } }}
        catch(Exception ex){
            System.out.println(ex);
        }
        return persons;
    }


    public static Person selectOne(int id) {

        Person person = null;
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                try(PreparedStatement preparedStatement = conn.prepareStatement(QueryConstant.SELECT_ONE)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) {
                        int prodId = resultSet.getInt(1);
                        String firstname = resultSet.getString(2);
                        String middlename = resultSet.getString(3);
                        String lastname = resultSet.getString(4);
                        String age = resultSet.getString(5);
                        String gender = resultSet.getString(6);
                        person = new Person(prodId, firstname, middlename, lastname, age, gender);
                    }}}}
        catch(Exception ex){
            System.out.println(ex);
        }
        return person;}


    public static int insert(Person person) {

        try{
            Class.forName("org.postgresql.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                try(PreparedStatement preparedStatement = conn.prepareStatement(QueryConstant.INSERT)){
                    preparedStatement.setString(1, person.getFirstname());
                    preparedStatement.setString(2, person.getMiddlename());
                    preparedStatement.setString(3, person.getLastname());
                    preparedStatement.setString(4,person.getAge());
                    preparedStatement.setString(5, person.getGender());
                    return  preparedStatement.executeUpdate();
                }}}
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;}

    public static int update(Person person) {

        try{
            Class.forName("org.postgresql.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                try(PreparedStatement preparedStatement = conn.prepareStatement(QueryConstant.UPDATE)){
                    preparedStatement.setString(1, person.getFirstname());
                    preparedStatement.setString(2, person.getMiddlename());
                    preparedStatement.setString(3, person.getLastname());
                    preparedStatement.setString(4,person.getAge());
                    preparedStatement.setString(5,person.getGender());
                    preparedStatement.setInt(6,person.getId());
                    return  preparedStatement.executeUpdate();
                } }}
        catch(Exception ex){
            System.out.println(ex);}
        return 0;}


    public static int delete(int id) {
        try{
            Class.forName("org.postgresql.Driver").newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                try(PreparedStatement preparedStatement = conn.prepareStatement(QueryConstant.DELETE)){
                    preparedStatement.setInt(1, id);
                    return  preparedStatement.executeUpdate();
                }}}
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;}
}