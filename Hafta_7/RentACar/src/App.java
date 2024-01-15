import business.UserManager;
import core.DbConnection;
import core.Helper;
import entities.User;
import view.AdminView;
import view.LoginView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        Helper.setTheme();
        //LoginView loginView = new LoginView();
        UserManager userManager = new UserManager();
        AdminView adminView = new AdminView(userManager.findByLogin("admin", "1234"));
    }
}
