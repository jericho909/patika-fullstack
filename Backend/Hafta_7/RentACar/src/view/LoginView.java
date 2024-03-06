package view;

import business.UserManager;
import core.Helper;
import entities.User;

import javax.swing.*;
import java.awt.*;

public class LoginView extends Layout{
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcomemsg;
    private JLabel lbl_welcomemsg2;
    private JPanel w_bottom;
    private JTextField field_username;
    private JPasswordField field_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private final UserManager userManager;

    public LoginView(){
        this.userManager = new UserManager();
        //draw the UI
        this.add(container);
        //when GUI is closed end the program
        layoutStart(400, 400);
        //making sure the fields are not empty
        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(this.field_username)){
                Helper.showErrorMessage("Username field cannot be empty.");
            } else {
                if (Helper.isFieldEmpty((this.field_password))){
                    Helper.showErrorMessage("Password field cannot be empty.");
                } else {
                    User loginUser = this.userManager.findByLogin(this.field_username.getText(), this.field_password.getText());
                    if (loginUser == null){
                        Helper.showErrorMessage("User not found.");
                    } else {
                        AdminView adminView = new AdminView(loginUser);
                        dispose();
                    }
                }
            }
        });

    }
}
