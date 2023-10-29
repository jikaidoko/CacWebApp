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
import ar.cac.abm.clases.Destino;

/**
 * Servlet implementation class AddDest
 */
public class AddDest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  desc = request.getParameter("desc-txt") ;
		double  precio =  Double.parseDouble(request.getParameter("precio-txt"));
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Conexion con = new Conexion("prueba","12345","cac_sist_reser") ;
		
		try {
			if (0 != con.agregarDestino(new Destino(desc,precio))) {
				pw.println("SE AGREGO REGISTRO");
			    pw.println(desc);
		        pw.println(precio);
		       }
			else {pw.println("NO SE AGREGO");}
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
