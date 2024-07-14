import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Chat extends JFrame implements ActionListener{
    private Container c;
    private ImageIcon icon;
    private JLabel user1Label;
    private JLabel user2Label;
    private JTextField user1TextField;
    private JTextField user2TextField;
    private JButton sendUser1Button;
    private JButton sendUser2Button;
    private JTextArea textArea;
    private JScrollPane scrollPane;

   Chat() {
        initComponents();
    }

    public void initComponents() {
        user1Label = new JLabel();
        user2Label = new JLabel();
        user1TextField = new JTextField();
        user2TextField = new JTextField();
        sendUser1Button = new JButton("Send User1");
        sendUser2Button = new JButton("Send User2");
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        c = this.getContentPane();
        c.setLayout(null);
        c.add(user1Label);
        c.add(user2Label);
        c.add(user1TextField);
        c.add(user2TextField);
        c.add(sendUser1Button);
        c.add(sendUser2Button);
        c.add(scrollPane);

        user1Label.setBounds(0, 0, 150, 50);
        user1Label.setHorizontalAlignment(JTextField.CENTER);
        user2Label.setBounds(0, 0, 150, 150);
        user2Label.setHorizontalAlignment(JTextField.CENTER);

        user1TextField.setBounds(115, 5, 205, 30);
        user2TextField.setBounds(115, 60, 205, 30);
        sendUser1Button.setBounds(115, 110, 100, 30);
        sendUser2Button.setBounds(220, 110, 100, 30);
        scrollPane.setBounds(50, 155, 300, 140);

        c.setBackground(Color.pink);

        icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        user1Label.setText("User1: ");
        user2Label.setText("User2: ");
        sendUser1Button.addActionListener(this);
        sendUser2Button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == sendUser1Button)
        {
            String message = user1TextField.getText();
            if (!message.isEmpty()) {
                appendMessage("User1 says: " + message);
                user1TextField.setText("");
            } else {
                showMessage("User1: Please enter a message!");
            }
        }
        else if(e.getSource() == sendUser2Button)
        {
            String message = user2TextField.getText();
            if (!message.isEmpty()) {
                appendMessage("User2 says: " + message);
                user2TextField.setText("");
            } else {
                showMessage("User2: Please enter a message!");
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(user1Label, message);
    }

    private void appendMessage(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        Class3 frame = new Class3();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 50, 400, 350);
        frame.setTitle("ChatApp");
        frame.setResizable(false);
    }
}