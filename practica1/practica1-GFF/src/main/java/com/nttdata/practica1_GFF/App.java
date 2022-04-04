package com.nttdata.practica1_GFF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        conexionOBDCEstablecida();
    }
    
    private void conexionOBDCEstablecida () {
    	
    	try {
    		
    		//driver de conexion bbdd
    		Class.forName("com.mysql.jdbc.Driver");
    		//url / contraseña / usuario
    		Connection connection = null;
    		connection = DriverManager.getConnection(
    		        "jdbc:mysql://192.168.0.26:3306/customerdb",
    		        "user", "123456");
    		
    		//consulta
    		final Statement sentence = connection.createStatement();
    		final String query = Select * from nttdata_mysql_soccer_player ;
    		
    	}
    }
    
    
}
