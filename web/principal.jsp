
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
       
    </head>
    <body>
        <header>
            <h1>Bienvenido a la Pagina Principal</h1> 
        </header>

        <section>
            <form action="ValidarServlet">
                <!--Enviamos al servlet-->
                <input type="text" name="caja1" placeholder="Ingrese producto">

                <input type="text" name="caja2" placeholder="Ingrese cantidad">

                <input type="text" name="caja3" placeholder="Ingrese Codigo">

                <input  type="submit" value="Enviar" >
            </form>
        </section>

    </body>


</html>