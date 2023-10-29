function abrirNuevo(){

  document.getElementById("form-nuevo").className = "row" ;

}
function cerrarNuevo(){

  const formulario =   document.getElementById("form-nuevo")
  const precio = document.getElementById("precio-txt")
  const descrip = document.getElementById("desc-txt")
    formulario.className = "d-none"
    precio.value = ""
    descrip.value = ""
    formulario.
}
const valores = window.location.search;

//Mostramos los valores en consola:
alert(valores);