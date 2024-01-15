import java.sql.*;

public class DBConnect {
        public static final String DB_URL = "jdbc:mysql://localhost/university";
        public static final String DB_USERNAME = "root";
        public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;

        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            conn.setAutoCommit(false);
            System.out.println("Successfully connected to the database.");
            statement = conn.createStatement();
//            ResultSet data = statement.executeQuery("SELECT * FROM student");
//            System.out.println("------------------");
//            while (data.next()){
//                System.out.println("STUDENT ID: " + data.getInt("student_id"));
//                System.out.println("STUDENT NAME: " + data.getString("student_name"));
//                System.out.println("STUDENT YEAR: " + data.getInt("student_year"));
//                System.out.println("------------------");
//            }
            //statement.executeUpdate("INSERT INTO student (student_name, student_year) VALUES ('Jack Smith', 3)");

//            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (student_name, student_year) VALUES (?, ?)");
//            preparedStatement.setString(1, "Donald Draper");
//            preparedStatement.setInt(2, 4);
//            preparedStatement.executeUpdate();
//            preparedStatement.close();
//
//            statement.executeUpdate("UPDATE student SET student_name='Jeffrey John Doe' WHERE student_id=1");
//            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE student SET student_name = ? WHERE student_id = 2");
//            preparedStatement.setString(1, "Mary Jane Doe");

            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO student (student_name, student_year) VALUES (?,?)");
            preparedStatement.setString(1,"Adam Smith");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();

            if (true){
                throw new SQLException();
            }

            preparedStatement.setString(1,"Karl Marx");
            preparedStatement.setInt(2, 4);
            preparedStatement.executeUpdate();

            conn.commit();  //---> just like git. if autoCommit is false you need to do it manually.
            preparedStatement.close();
            conn.close();

        }catch (SQLException e){
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            System.out.println(e.getMessage());
        }
    }
}
