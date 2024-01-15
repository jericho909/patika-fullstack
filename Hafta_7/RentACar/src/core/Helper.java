package core;

import view.LoginView;

import javax.swing.*;

public class Helper {

    //sets the theme to Nimbus
    public static void setTheme(){
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }

    }

    public static boolean confirm(String str){
        String msg;
        if (str.equals("Yes")){
            msg = "Please confirm deletion.";
        } else {
            msg = str;
        }

        return JOptionPane.showConfirmDialog(null, msg,"Are you sure?", JOptionPane.YES_NO_OPTION) == 0;
    }

    public static void showErrorMessage(String str){
        JOptionPane.showMessageDialog(null, str, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(String str, String title){
        JOptionPane.showMessageDialog(null, str, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean isFieldEmpty(JTextField field){
        return field.getText().trim().isEmpty();
    }
}
