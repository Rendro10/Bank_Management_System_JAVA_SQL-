package bank.management.system1;
//* imporat the all features of swings
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
        
public class Login extends JFrame implements ActionListener {
    
    JButton login, signUp, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
       
        
        // default LayOut
        setLayout(null);
        
        // title of the layout
         setTitle("Bank Management System");
         
        
        // Image icon of atm in login page 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        
        // Title of front page
        JLabel text = new JLabel(" Welcome TO ATM ");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(200,40,410,40);
        add(text);
        
        // text for card number 
        JLabel cardno = new JLabel(" CARD NO: ");
        cardno.setFont(new Font("Italic", Font.BOLD,32));
        cardno.setBounds(120,150,200,40);
        add(cardno);
        
        //Text area of card number:->
        cardTextField =  new JTextField();
        cardTextField.setBounds(320,150,250,40);
        cardTextField.setFont(new Font("Arial",  Font.BOLD, 14));
        add(cardTextField);
        
        
        
        
         // text for PIN number 
        JLabel pin = new JLabel(" PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD,32));
        pin.setBounds(120,220,150,40);
        add(pin);
        
        //Text area of card number:->
        pinTextField =  new JPasswordField();
        pinTextField.setBounds(320,230,250,40);
        pinTextField.setFont(new Font("Arial",  Font.BOLD, 14));
        add(pinTextField);
        
        
        login = new JButton("SIGN IN");
        login.setBounds(320,300,100,30);
        add(login);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(470,300,100,30);
        add(clear);
        clear.addActionListener(this);
        
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(320,350,250,30);
        add(signUp);
        signUp.addActionListener(this);
        
        
        // set background color of the frame and height width set
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,480);
        setVisible(true); // to show frame 
        setLocation(230,200); // set location that where the frame open
       
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            conn con = new conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            String query = "SELECT * FROM login WHERE Account_number = '"+cardnumber+"' and Pin_Number ='"+pinnumber+"'";
            
            try{
                ResultSet rs = con.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login(); // calling function
    }
    
}
