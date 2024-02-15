package Assignment5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Database {
    private Connection connection;

    // connection from DB to JAVA with jdbc
    public Database() {
        try {
            String url = key.getUrl();
            String user = key.getUser();
            String password = key.getPass();
            connection =  DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    // prepearedStatement - the most popular feature for adding/updating some statements as a request for something
    public void addPerson (String name, int age, String status) {
        try {
            String query = "INSERT INTO people (name, age, status) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getting list of people
    public List<Person> getPeople(){
        // creating list for all people
        List<Person> people = new ArrayList<>();

        try{
            String query = "SELECT * FROM people";

            // by statement, I can get values of fields such us "id", "name" and etc
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String status = resultSet.getString("status");
                people.add(new Person(id, name, species, age, status));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return people;
    }

    public void updatePerson(int id, String name, int age, String status){
        try {
            String query = "UPDATE people SET name=?, age=?, status=? WHERE id=?";
g
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, status);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
