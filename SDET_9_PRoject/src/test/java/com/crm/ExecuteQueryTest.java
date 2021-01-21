package com.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class ExecuteQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
			try {
				//step 1 : rigester the database 
			      Driver mysqlDriverR = new Driver();
			      DriverManager.registerDriver(mysqlDriverR);
			  
				//step 2 : connect to database 
			        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			      
				//step 3 : create a statement ref
			       Statement stat = con.createStatement();
			       
			       
				//step 4: execute Query
			      ResultSet result=  stat.executeQuery("select * from project");
			            
			              while (result.next()) {
						        System.out.println(result.getNString(1) + "\t" + result.getNString(2)+ "\t" + result.getNString(4)+ "\t" + result.getInt(6));
						}
			      
			}catch (Exception e) {
					System.err.println("query is invalid");
			}finally {
					//step 5: close the conection
				 con.close();
				 System.out.println("close");
			}
        
	}

}
