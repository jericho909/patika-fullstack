import core.DbConnection;
import core.Helper;
import view.LoginView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        Helper.setTheme();
        LoginView loginView = new LoginView();
    }
}
