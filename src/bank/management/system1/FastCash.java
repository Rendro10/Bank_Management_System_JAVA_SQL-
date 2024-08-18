package bank.management.system1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton thousand,twoThousand,ThreeThousand,FourThousand,FiveThousand,sixThousand,TenThousand,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdraw Amount");
        text.setBounds(220,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        thousand= new JButton ("RS.1000");
        thousand.setBounds(170,415,150,30);
        thousand.addActionListener(this);
        add(thousand);
        
        twoThousand= new JButton ("RS.2000");
        twoThousand.setBounds(355,415,150,30);
        twoThousand.addActionListener(this);
        add(twoThousand);
        
        ThreeThousand= new JButton ("RS.3000");
        ThreeThousand.setBounds(170,450,150,30);
        ThreeThousand.addActionListener(this);
        add(ThreeThousand);
        
        FourThousand= new JButton ("RS.4000");
        FourThousand.setBounds(355,450,150,30);
        FourThousand.addActionListener(this);
        add(FourThousand);
        
        FiveThousand= new JButton ("RS.5000");
        FiveThousand.setBounds(170,485,150,30);
        FiveThousand.addActionListener(this);
        add(FiveThousand);
        
        sixThousand= new JButton ("RS.6000");
        sixThousand.setBounds(355,485,150,30);
        sixThousand.addActionListener(this);
        add(sixThousand);
        
        TenThousand= new JButton ("RS.10000");
        TenThousand.setBounds(170,520,150,30);
        TenThousand.addActionListener(this);
        add(TenThousand);
        
        exit = new JButton ("Back");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            conn c = new conn();
             try{
                 ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()){
                     if(rs.getString("type").equals("Deposit")){
                         balance += Integer.parseInt(rs.getString("amount"));
                     }
                     else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                     }
                 }
                 if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficient Balance");
                     return;
                 }
                 
                 Date date = new Date();
                 
                 String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"RS."+amount+ " Debited Successfully.");
                 
                 setVisible(false);
                 new Transactions(pinnumber).setVisible(true);
             }catch(Exception e){
                 System.out.println(e);
             }
        }
//        else if(ae.getSource()==deposit){
//            setVisible(false);
//            new Deposit(pinnumber).setVisible(true);
//        }
//        else if(ae.getSource()==withdrawl){
//            setVisible(false);
//            new Withdrawl(pinnumber).setVisible(true);
//        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}

