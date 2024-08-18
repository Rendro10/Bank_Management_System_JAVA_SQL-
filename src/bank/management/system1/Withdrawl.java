package bank.management.system1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw,exit;
    String pinnumber;
    Withdrawl(String pinnumber){
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Enter Amount You want to Withdraw: ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
    
       
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        
        if(ae.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount You want to withdraw");
                
            }
            else{
                try{
                    
                    String query = "INSERT INTO bank VALUES('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    conn con = new conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"RS "+number+" Withdrawl Sucesfully. Take Your Cash! Thank you Visit Again!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                    
                } catch(Exception e){
                    System.out.println(e);
                }
//                
            }
        }
        else if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
