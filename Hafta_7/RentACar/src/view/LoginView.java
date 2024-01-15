package view;

import business.UserManager;
import core.Helper;
import entities.User;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame{
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Rent A Car");
        //the dimensions of the GUI
        this.setSize(400,400);
        //calculating the viewpoet to be in the middle of the users screen
        int userViewportHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - this.getSize().height) / 2;
        int userViewportWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - this.getSize().width) / 2;
        this.setLocation(userViewportWidth, userViewportHeight);
        this.setVisible(true);
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
                        System.out.println(loginUser.toString());
                    }
                }
            }
        });

    }
}
