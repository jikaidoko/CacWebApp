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
 * Servlet implementation class holamundo
 */
public class holamundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public holamundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Conexion con;
		
			 con = new Conexion("prueba","12345","cac_sist_reser") ;
			 
	   
						
		 try {
			for( Destino a : con.listaDestino()) {
				
				pw.println(a.getId() + " " + a.getDestino() + " " + a.getPrecio());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		/*	pw.println("<html><head>");
		pw.println("<TITLE>Servlet Maven</TITLE>");
		pw.println("</head><body>");
		pw.println("<p>Hola Mundo</p>");
		pw.println("</body>");
		pw.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
