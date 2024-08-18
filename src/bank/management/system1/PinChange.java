package bank.management.system1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
     JTextField pin,repin;
     JButton change,exit;
     String pinnumber;
     
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Change Your Pin ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("Enter New Pin : ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pin = new JTextField();
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(330,320,180,25);
        image.add(pin);
        
        
        
        JLabel repintext = new JLabel("Confirm New Pin : ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin = new JTextField();
        repin.setFont(new Font("Raleway",Font.BOLD,22));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        
        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Pin Does not match!");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin!");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter Pin!");
                    return;
                }
                
                conn c = new conn();
                String query1 = "update bank set pin = '"+rpin+"' WHERE pin='"+pinnumber+"'";
                String query2 = "update login set Pin_Number = '"+rpin+"' WHERE Pin_Number='"+pinnumber+"'";
                String query3 = "update signupthree set Pin_No = '"+rpin+"' WHERE Pin_No='"+pinnumber+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,"PIN CHANGED SUCCESSFULLY!");
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
