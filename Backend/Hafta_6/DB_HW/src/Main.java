import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = conn.createStatement();
            System.out.println("Connected to database.");


            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employee (employee_name, " +
                    "employee_position, employee_salary) VALUES (?,?,?)");

            preparedStatement.setString(1, "John Doe");
            preparedStatement.setString(2, "Junior Engineer");
            preparedStatement.setDouble(3, 36.000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Jane Doe");
            preparedStatement.setString(2, "Senior Engineer");
            preparedStatement.setDouble(3, 60.000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Jack Smith");
            preparedStatement.setString(2, "UI Designer");
            preparedStatement.setDouble(3, 32.000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Mary Sue");
            preparedStatement.setString(2, "Systems Engineer");
            preparedStatement.setDouble(3, 72.000);
            preparedStatement.executeUpdate();

            preparedStatement.setString(1, "Stan Smith");
            preparedStatement.setString(2, "Project Manager");
            preparedStatement.setDouble(3, 96.000);
            preparedStatement.executeUpdate();

            ResultSet data = statement.executeQuery("SELECT * FROM employee");
            System.out.println("------------------");
            while (data.next()){
                System.out.println("EMPLOYEE ID: " + data.getInt("employee_id"));
                System.out.println("EMPLOYEE NAME: " + data.getString("employee_name"));
                System.out.println("EMPLOYEE POSTION: " + data.getString("employee_position"));
                System.out.println("EMPLOYEE SALARY: " + data.getDouble("employee_salary"));
                System.out.println("------------------");
            }

            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}