<%-- 
    Document   : Login
    Created on : 06/09/2016, 11:56:02
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Login | Monitoria</title>

        <link rel="stylesheet" href="CSS/Login.css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                
                <h3>Sistema Monitoria</h3>
                
                <form class="Login"  action="Login" >
                    <input name="login" type="text" placeholder="Login"/>
                    <input name="senha" type="password" placeholder="Senha"/>
                    
                    <button>Login</button>
                </form>
            </div>
        </div>

    </body>
</html>