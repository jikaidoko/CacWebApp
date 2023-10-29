package ar.cac.abm.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
 
	
	public Connection con;
	public Statement stm;
	
	public Conexion (String usuario, String pass , String database) {
		
		
			try {
				this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ database,usuario,pass);
				this.stm = this.con.createStatement(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
		
		
	}
	
	
public  List<Destino> listaDestino() throws SQLException   {
		
	   ResultSet rs =  this.stm.executeQuery("select * from destinos");
		ArrayList<Destino> dest = new ArrayList<Destino>();
			
		while (rs.next()){
			
			dest.add(new Destino(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
					
		}
		
		
		
		return dest ;
		
	   			
	}
public int eliminarDestino(int id) throws SQLException {
	
	return this.stm.executeUpdate("delete from destinos where id="+ id );
	
}
	
public int agregarDestino(Destino des) throws SQLException {
	
	String sqlQ	= "insert into destinos (destino , precio) values (?,?)";
	PreparedStatement stm  =  this.con.prepareStatement(sqlQ);
	
	stm.setString(1, des.getDestino());
	stm.setDouble(2, des.getPrecio());
	
	
	return stm.executeUpdate();
	
	}	

public int actualizarDestino(Destino des) throws SQLException {
	
	String sqlQ	= "update destinos set destino = ? , precio = ? where id = ?";
	PreparedStatement stm  =  this.con.prepareStatement(sqlQ);
	
	stm.setString(1, des.getDestino());
	stm.setDouble(2, des.getPrecio());
	stm.setInt(3, des.getId());
	
	return stm.executeUpdate();
	
	}
	
	
	
	
	public void cerrarConexion() {
		
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
