package bank.management.system1;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser; // Before import i added library jcalander from right clickling on Libraries and add jar/Folder
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,other,married,single,Others;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        //  by default layout null to manage content position according to me
        setLayout(null);
        
        Random ran = new Random();
        long random = (Math.abs((ran.nextLong() % 9000L ) + 1000L));
        
    
        
        JLabel formno = new JLabel("Application Form Number:" + random );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        // All Personal Details Label's Code is Here->
        
        JLabel personalDetails = new JLabel("Page-1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        
        JLabel name = new JLabel(" Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(105,190,200,30);
        add(fname);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(105,240,200,30);
        add(dob);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(105,290,200,30);
        add(gender);
        
        JLabel emailAddress = new JLabel("Email Id:");
        emailAddress.setFont(new Font("Raleway",Font.BOLD,20));
        emailAddress.setBounds(105,340,200,30);
        add(emailAddress);
        
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(105,390,200,30);
        add(maritalStatus);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(105,440,200,30);
        add(address);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(105,490,200,30);
        add(city);
        
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(105,540,200,30);
        add(state);
        
        
        JLabel pin = new JLabel("Pincode:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(105,590,200,30);
        add(pin);
        
        
        // All TextField of those labels are here->
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        // For DOB calender setting->
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        // Radio Buttons for Gender->
        male = new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(630,290,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        // It is handling the that we can select radio button one at a time.
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
        
        // Radio Buttons for MArital Status->
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        
        single = new JRadioButton("Single");
        single.setBounds(450,390,100,30);
        single.setBackground(Color.WHITE);
        add(single);
        
        
        Others = new JRadioButton("Others");
        Others.setBounds(630,390,100,30);
        Others.setBackground(Color.WHITE);
        add(Others);
        
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(single);
        maritalGroup.add(Others);
        
        
        // Code for Next Button to change the page->
        
        JButton next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);  
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
                 
    }
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(female.isSelected()){
            gender = "Female";
        }
        else if(other.isSelected()){
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        
        String marital = null;
        
        if(single.isSelected()){
            marital = "Single";
        }
        else if(married.isSelected()){
            marital = "Married";
        }
        else if(Others.isSelected()){
            marital = "Others";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
         
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required:");
            }
            else{
                conn c = new conn();
                String query = "INSERT INTO signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true); 
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupOne(); 
    }
 }
 









