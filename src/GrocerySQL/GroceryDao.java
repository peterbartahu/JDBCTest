package GrocerySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroceryDao {
    Connection connection = null;
    Statement query = null;
    ResultSet resultSet = null;

    public void insertValue(final String name) {
        connection();
        try {
            query = connection.createStatement();
            query.executeUpdate("INSERT INTO groceries(name) VALUES('" + name + "')");
        } catch (final Exception e) {
            System.out.println("Sikertelen beillesztés");
            e.printStackTrace();
        }
    }

    public void deleteValue(final String name) {
        connection();
        try {
            query = connection.createStatement();
            query.executeUpdate("DELETE FROM groceries WHERE name LIKE('" + name + "')");
        } catch (final Exception e) {
            System.out.println("Sikertelen beillesztés");
            e.printStackTrace();
        }
    }

    public void selectValue() {
        connection();
        try {
            query = connection.createStatement();
            resultSet = query.executeQuery("SELECT name FROM groceries");
            int i = 0;
            while (resultSet.next()) {
                System.out.print(++i + ". # ");
                final String table = resultSet.getString("name");
                System.out.println(table);
            }
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateValue(final String oldValue, final String newValue) {
        connection();
        try {
            query = connection.createStatement();
            query.executeUpdate(
                "UPDATE groceries SET name = '" + newValue + "' WHERE name LIKE '" + oldValue + "'");
        } catch (final Exception e) {
            System.out.println("Sikertelen beillesztés");
            e.printStackTrace();
        }
    }

    /**
     * You have to fill the database username and password!!!!!
     * connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerylist", "!!!!!" "!!!!");
     */
    private void connection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocerylist", "***", "***");
        } catch (final SQLException e) {
            e.printStackTrace();
        }
    }
}
