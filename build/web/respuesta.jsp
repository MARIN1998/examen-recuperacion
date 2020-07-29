<%-- 
    Document   : respuesta
    Created on : 28-jul-2020, 23:42:10
    Author     : ACER
--%>

<%
    Double monto = (Double) request.getAttribute("totalapagarjsp");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
        <title>Total a pagar</title>
    </head>
    <body>
    
        <section>
            <form>
                <h1>Total a pagar</h1>
                <%=monto%>
  

            </form>
        </section>

   

    </body>
</html>
