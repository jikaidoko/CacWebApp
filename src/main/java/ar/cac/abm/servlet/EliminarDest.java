package ar.cac.abm.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import ar.cac.abm.clases.Conexion;

/**
 * Servlet implementation class EliminarDest
 */
public class EliminarDest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarDest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id")) ;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Conexion con = new Conexion("prueba","12345","cac_sist_reser") ;
		
		try {
			if (0 != con.eliminarDestino(id)) {
				
				pw.println("Se Elimino el registro " + id );
			}
			else {
				
				pw.println("No se Elimino Ningun Registro");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	
		
		
		pw.println("<br><br><a href= 'destinos.jsp'>Home</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
