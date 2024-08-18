package bank.management.system1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import java.util.*;
//import com.toedter.calendar.JDateChooser; // Before import i added library jcalander from right clickling on Libraries and add jar/Folder
//import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField PanNoaddressTextField,AdhaarTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,CategoryName,IncomeDetails,EduQalification,incomeSource;
    String formno;
    
    SignupTwo(String formno){
        
        this.formno = formno;
        
        //  by default layout null to manage content position according to me
        setLayout(null);
        
        setTitle("New Account Application Form Page-2");
        
        
    
        
        
        // All Personal Details Label's Code is Here->
        
        JLabel additionalDetails = new JLabel("Page-2 Additional  Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
         
        JLabel Religionname = new JLabel(" Religion:");
        Religionname.setFont(new Font("Raleway",Font.BOLD,20));
        Religionname.setBounds(100,140,100,30);
        add(Religionname);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(105,190,200,30);
        add(fname);
        
        String valCategory[] = {"General","OBC","ST","SC","Other"};
        CategoryName = new JComboBox(valCategory);
        CategoryName.setBounds(300,190,400,30);
        CategoryName.setBackground(Color.WHITE);
        add(CategoryName);
        
        
        
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(105,240,200,30);
        add(income);
        
        String valIncome[] = {"NULL","Below 1.5 lakh/year","Below 2.5 lakh/year","Below 8 lakh/year","Above 8 lakh/year"};
        IncomeDetails = new JComboBox(valIncome);
        IncomeDetails.setBounds(300,240,400,30);
        IncomeDetails.setBackground(Color.WHITE);
        add(IncomeDetails);
        
        
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(105,290,200,30);
        add(education);
        
        JLabel qualify = new JLabel("Qualification:");
        qualify.setFont(new Font("Raleway",Font.BOLD,20));
        qualify.setBounds(105,315,200,30);
        add(qualify);
        
        String Qualification[] = {"Non Graduate", "Graduate","Post Graduate","Doctorate","Others"};
        EduQalification = new JComboBox(Qualification);
        EduQalification.setBounds(300,315,400,30);
        EduQalification.setBackground(Color.WHITE);
        add(EduQalification);
        
        
        
        JLabel maritalStatus = new JLabel("Occupation:");
        maritalStatus.setFont(new Font("Raleway",Font.BOLD,20));
        maritalStatus.setBounds(105,390,200,30);
        add(maritalStatus);
        
        String QualificationVal[] = {"Salaried", "Self Employed","Business","Student","Others"};
        incomeSource = new JComboBox(QualificationVal);
        incomeSource.setBounds(300,390,400,30);
        incomeSource.setBackground(Color.WHITE);
        add(incomeSource);
        
        
        
        JLabel PanNo = new JLabel("Pan No:");
        PanNo.setFont(new Font("Raleway",Font.BOLD,20));
        PanNo.setBounds(105,440,200,30);
        add(PanNo);
        
        PanNoaddressTextField = new JTextField();
        PanNoaddressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        PanNoaddressTextField.setBounds(300,440,400,30);
        add(PanNoaddressTextField);
        
        
        
        JLabel Adhaar = new JLabel("Aadhar No:");
        Adhaar.setFont(new Font("Raleway",Font.BOLD,20));
        Adhaar.setBounds(105,490,200,30);
        add(Adhaar);
        
        AdhaarTextField = new JTextField();
        AdhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
        AdhaarTextField.setBounds(300,490,400,30);
        add(AdhaarTextField);
        
        
        JLabel Senior = new JLabel("Senior Cityzen:");
        Senior.setFont(new Font("Raleway",Font.BOLD,20));
        Senior.setBounds(105,540,200,30);
        add(Senior);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        
        sno = new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
     
        
        
        ButtonGroup smaritalGroup = new ButtonGroup();
        smaritalGroup.add(syes);
        smaritalGroup.add(sno);
  
        
        
        JLabel pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(105,590,200,30);
        add(pin);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        
        eno = new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
     
        
        
        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);
        
        
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
        
        String sreligion  = (String) religion.getSelectedItem();
        String scategory = (String) CategoryName.getSelectedItem();
        String sincome = (String) IncomeDetails.getSelectedItem();
        String seducation = (String) EduQalification.getSelectedItem();
        String socupation = (String) incomeSource.getSelectedItem();
      
        
        String SeniorCityzen = null;
        if(syes.isSelected()){
            SeniorCityzen = "Yes";
        }
        else if(sno.isSelected()){
            SeniorCityzen = "No";
        }
        
//        String email = emailTextField.getText();
        
        
        String existingAcc = null;
        if(eyes.isSelected()){
            existingAcc = "Yes";
        }
        else if(eno.isSelected()){
            existingAcc = "No";
        }
        
        
        String epan = PanNoaddressTextField.getText();
        String eaadhar = AdhaarTextField.getText();
         
        
        try{
            
                conn c = new conn();
                String query = "INSERT INTO signuptwo  values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+socupation+"','"+epan+"','"+eaadhar+"','"+SeniorCityzen+"','"+existingAcc+"')";
                c.s.executeUpdate(query);
                
                //signup-3 formno pass
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String args[]){
        new SignupTwo(""); 
    }
 }
 









