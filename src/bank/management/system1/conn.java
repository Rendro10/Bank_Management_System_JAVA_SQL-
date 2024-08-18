package bank.management.system1;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
//            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root@localhost","Rickarka@445");    
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "Rickarka@445"); 
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  