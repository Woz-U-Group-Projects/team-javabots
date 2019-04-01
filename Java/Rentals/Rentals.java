package com.props.rentals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Rentals {
	
	public static void main(String[] args) {
        SpringApplication.run(Rentals.class, args);

        // connection to the database
        Connection con;

        try {
        	
        	con = DriverManager.getConnection("jdbc:sqlite:./rentals.db", "", "");
	
        	Statement stmt = con.createStatement();
        	
        	ResultSet rs = stmt.executeQuery("SELECT * FROM Homes");
        	
        	int homeId;
            String homeType;
            int homeZipCode;
            
            while (rs.next()) {
            	
            	homeId = rs.getInt("HomeId");
                homeType = rs.getString("Type");
                homeZipCode = rs.getInt("ZipCode");
                
                System.out.println("Home ID: '" + homeId + "', Type: '" + homeType + "', Zip Code: '" + homeZipCode + "'.");
            }
        } catch (SQLException e) {
            // print the stack trace of the error
            e.printStackTrace();
        }
	}
} 