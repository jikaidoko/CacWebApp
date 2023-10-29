const calcular = () => {
    const ticket = 1000;
    let total = 0;
    let cant= document.querySelector("#cant").value
    let desc = document.querySelector("#desc").value
    let subtotal = cant * ticket

    total = subtotal - [(subtotal * desc) / 100]


    return (
        document.querySelector("#subTotal").innerText = subtotal > 1 ? subtotal : '0',
        document.querySelector("#total").innerText = total > 1 ? total : '0',
        document.querySelector("#tickets").innerText=cant?cant:'0'
    )
}

document.querySelector('[name=diez]').classList.add("tarjeta-naranja")

const desc=(id)=>{
    return(
    document.querySelector("#desc").value=id,
    id==='10'?(document.querySelector('[name=diez]').classList.add("tarjeta-naranja"),document.querySelector('[name=treinta]').classList.remove("tarjeta-naranja"),document.querySelector('[name=cincuenta]').classList.remove("tarjeta-naranja")):null,
    id==='30'?(document.querySelector('[name=treinta]').classList.add("tarjeta-naranja"),document.querySelector('[name=diez]').classList.remove("tarjeta-naranja"),document.querySelector('[name=cincuenta]').classList.remove("tarjeta-naranja")):null,
    id==='50'?(document.querySelector('[name=cincuenta]').classList.add("tarjeta-naranja"),document.querySelector('[name=diez]').classList.remove("tarjeta-naranja"),document.querySelector('[name=treinta]').classList.remove("tarjeta-naranja")):null,
    calcular()
    )
}
const select=document.querySelector("select")
select.addEventListener('input',(e)=>{
        console.log(e.target.value)
        desc(e.target.value)
})

const validarEmail=(email)=>{
    var expReg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

    var testeo =expReg.test(email)

    return testeo

}



const form=document.querySelector("#form")

form.addEventListener('submit',(e)=>{
    e.preventDefault()

    email=document.querySelector('[name=email]').value
    var testEmail=validarEmail(email)
    if(testEmail){
     tickets=document.querySelector("#tickets").innerText
     total=document.querySelector("#total").innerText
      descuento=document.querySelector("#desc").value
      return(  Swal.fire({
            title:'Resumen de Compra',
            html:`<p style="text-align:left;padding:5px"><b>Compraste</b> ${tickets} pasajes,  por un total de <b>$${total}</b> con todo incluido</p>`,
            width:'300px',
            showCancelButton:true,
            showConfirmButton:false,
            cancelButtonText:'<span style="border:none !important;font-size:16px;color:white;font-weight:bold">X</span>',
            color:'black',
            background:'white'
         
        
        }),e.target.reset(),reset())
        
       
    }else if(!testEmail){

        Swal.fire({
            text:'Correo electronico invalido',
            width:'250px',
            timer:'4000',
            showCancelButton:false,
            showConfirmButton:false
        })
    }  
    
    
})


const reset=()=>{
    document.querySelector("#subTotal").innerText ='0',
    document.querySelector("#total").innerText = '0'
    document.querySelector("#tickets").innerText='0'
    document.querySelector('[name=diez]').classList.add("tarjeta-naranja")
    document.querySelector('[name=cincuenta]').classList.remove("tarjeta-naranja")
    document.querySelector('[name=treinta]').classList.remove("tarjeta-naranja")
}