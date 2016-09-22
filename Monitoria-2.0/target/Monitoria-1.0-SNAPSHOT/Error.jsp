<%@page import="Instituicao.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    Instituicao instituicao = (Instituicao)session.getAttribute("Instituicao");
    
    String link= "Login.jsp";
    
    if(instituicao != null)
    {
        link= "Index.jsp";
    }
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
            <meta charset="UTF-8">
            <title>Erro - Monitoria</title>

            <link rel="stylesheet" href="Login/CSS/Login.css"/>
    </head>

    <body>
        <div class="login-page">
            <div class="form">
                <h1><b>Erro 404</b><h1>
                <p class="error">Não foi possível exibir a página ou ao comando<br><br>
                            <a href="<%=link%>">Deseja voltar ao início?</a>
                </p>
            </div>
        </div>

  </body>
</html>