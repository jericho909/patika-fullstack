package dao;

import core.DbConnection;
import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private final Connection conn;

    public UserDao(){
        this.conn = DbConnection.getInstance();
    }

    public ArrayList<User> findAllUsers(){
        ArrayList<User> usersList = new ArrayList<>();
        try{
            String query = "SELECT * FROM public.user";
            ResultSet rs = this.conn.createStatement().executeQuery(query);
            while (rs.next()){
                usersList.add(this.match(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return usersList;
    }

    public User findByLogin(String username, String password){
        User obj = null;
        String query = "SELECT * FROM public.user WHERE user_name = ? AND user_password = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                obj = this.match(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return obj;
    }

    public User match(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUser_id(rs.getInt("user_id"));
        user.setUser_name(rs.getString("user_name"));
        user.setUser_password(rs.getString("user_password"));
        user.setUser_role(rs.getString("user_role"));

        return user;
    }
}
