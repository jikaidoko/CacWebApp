<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ar.cac.abm.clases.Destino"%>
<%@ page import="ar.cac.abm.clases.Conexion"%>
<%@ page import="java.sql.SQLException"%>
<%Conexion con;

con = new Conexion("prueba","12345","cac_sist_reser") ;


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SISTEMA DE GESTION DE VIAJES</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">ADMINISTRACION DE PAQUETES</h1>
	</div>

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">DESTINO</th>
					<th scope="col">PRECIO</th>
					<th scope="col">ACCIONES</th>
				</tr>
			</thead>
			<tbody>

				<%for( Destino a : con.listaDestino()) { %>

				<tr>
					<th scope="row"><%=a.getId()%></th>
					<td><%=a.getDestino() %></td>
					<td><%=a.getPrecio()%></td>
					<td><a href="EliminarDest?id=<%=a.getId() %>"
						class="btn btn-danger">ELIMINAR</a> <a
						href="destinos.jsp?id=<%=a.getId() %>&desc=<%=a.getDestino() %>&precio=<%=a.getPrecio()%> "
						class="btn btn-success">ACTUALIZAR</a></td>
				</tr>


				<%
}
%>
			</tbody>
		</table>
		<div class="d-flex justify-content-end mb-3">
			<button id="nuevo" class="btn btn-warning" onclick="abrirNuevo()">
				NUEVO</button>
		</div>
	</div>
	<div id="" class="container mb-3">

		<div id="form-nuevo" class="row d-none">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<form id="form-action" method="get" action="AddDest">
					<div
						class="mb-3 d-flex flex-column gap-3 justify-content-spacebetween">

						<input type="text" class="form-control" name="id-txt"
							id="id-txt" placeholder="id" readonly>
						<textarea id="desc-txt" name="desc-txt" rows="5"
							class="w-100 border fs-5 ps-2 form-control"
							placeholder="Descripcion"></textarea>
						<input type="text" class="form-control" name="precio-txt"
							id="precio-txt" placeholder="Precio">
					</div>
					<div class="mb-3">
						<div>
							<button type="submit" class="btn btn-success w-100">Enviar</button>
						</div>
						<div class="d-flex justify-content-end ">
							<button id="cerrar-nuevo" type="button" class="btn-close mt-1"
								onclick="cerrarNuevo()" aria-label="Close"></button>
						</div>

					</div>

				</form>

			</div>
			<div class="col-lg-2"></div>



		</div>

	</div>

	<script>
// veo si vienen parametros - si es vienen es por que llame actualizar
const valores = window.location.search;
const urlParams = new URLSearchParams(valores);
const id = urlParams.get('id');
const desc = urlParams.get('desc');
const precio = urlParams.get('precio');
if (id != null){
	document.getElementById("form-nuevo").className = "row";
	document.getElementById("form-action").setAttribute('action', 'ActDest')
	document.getElementById("id-txt").className = "form-control" 
	document.getElementById("id-txt").value = id
	document.getElementById("desc-txt").value = desc
	document.getElementById("precio-txt").value = precio
	
}



function abrirNuevo(){

	  document.getElementById("form-nuevo").className = "row" ;
	  document.getElementById("form-action").setAttribute('action', 'AddDest')
	  document.getElementById("id-txt").className = "d-none"
	  limpiarForm();

	}
function cerrarNuevo(){
        
	    document.getElementById("form-nuevo").className = "d-none"
	    limpiarForm()
	    
	}
	
function limpiarForm(){
	 document.getElementById("precio-txt").value = ""
	 document.getElementById("desc-txt").value = ""
	 document.getElementById("id-txt").value = "d-none"
	 document.getElementById("id-txt").value = ""
}
	

</script>
</body>
</html>