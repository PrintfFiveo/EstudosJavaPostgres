import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPasswordField passwordField1;
    private JTextField Email;
    private JButton OKButton;
    private JButton CANCELButton;
    private JPanel Panel_Login;
    public Login(JFrame parent) {
        setMinimumSize(new Dimension(400, 300));
        UserLogin a = new UserLogin();
        setContentPane(Panel_Login);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = Email.getText();
                String password = passwordField1.getText();
                a.getUser(email, password);
                if(a.db.user != null){
                    dispose();

                }
            }
        });


    }
}
