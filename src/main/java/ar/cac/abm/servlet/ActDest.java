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
 * Servlet implementation class ActDest
 */
public class ActDest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActDest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id-txt"));
		String  desc = request.getParameter("desc-txt") ;
		double  precio =  Double.parseDouble(request.getParameter("precio-txt"));
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Conexion con = new Conexion("prueba","12345","cac_sist_reser") ;
		
		try {
			if (0 != con.actualizarDestino(new Destino(id,desc,precio))) {
				pw.println("SE ACTUALIZO REGISTRO");
				pw.println(id);
				
		       }
			else {pw.println("NO SE ACTUALIZO");}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.print("<meta http-equiv='refresh' content=5;URL='destinos.jsp'>");
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
