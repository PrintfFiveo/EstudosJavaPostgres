import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstForm extends JFrame {
    private JPanel panel1;
    private JTextField nameTex;
    private JTextField EmailTex;
    private JFormattedTextField phonenum;
    private JTextField adressField;
    private JPasswordField psswdField;
    private JButton registerButton;
    private JButton cancelButton;
    private JPasswordField psswdconfField;


    public FirstForm(JFrame parent) {
        setLocationRelativeTo(parent);
        setTitle("App");
        setMinimumSize(new Dimension(450, 475));
        setResizable(true);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }});
        cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }});
    setVisible(true);}

    private void registerUser() {
        DatabaseFunc db = new DatabaseFunc();
        String name = nameTex.getText();
        String email = EmailTex.getText();
        String password = String.valueOf(psswdField.getPassword());
        String confirmPassword = String.valueOf(psswdconfField.getPassword());
        String phoneNumber = phonenum.getText();
        String address = adressField.getText();



        if (name.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(FirstForm.this,
                    "All fields are required",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
                    return;
                }
                /* /// breaks single responsibility principle? */
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(FirstForm.this,
                    "Password does not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }
        db.insert_row("users", name, address , phoneNumber,email, password);



    }}




