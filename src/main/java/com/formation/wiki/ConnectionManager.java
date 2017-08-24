package com.formation.wiki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
	
	public static String url="jdbc:mysql://localhost:3306/wiki";
	public static String user="root";
	public static String password="";
	
	public static Connection getConnexion() {
		Connection con = null;
		try{
			
			//pour charger le driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			// pour recuperer une connexion
			con = DriverManager.getConnection(url, user, password);
			//System.out.println("Connection established");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Error");
		} catch (SQLException e) {
			System.out.println("BDD Error");
		}
		return con;
	}

}
