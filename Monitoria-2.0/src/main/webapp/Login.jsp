<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
            <meta charset="UTF-8">
            <title>Bem Vindo</title>

            <link rel="stylesheet" href="Login/CSS/Login.css"/>
    </head>

    <body>
        <div class="login-page">
            <div class="form">
                <form class="register-form" action="CadastroInstituicao">
                    <h1>Sistema Monitoria</h1>

                    <input name="nome"  type="text" placeholder="Nome da Instituição"/>
                    <input name="email"  type="text" placeholder="e-Mail"/>
                    <input name="cnpj"  type="text" placeholder="CNPJ"/>
                    <input name="cartao"  type="text" placeholder="Cartão de Crédito"/>
                    <input name="senha"  type="password" placeholder="Senha"/>
                    <button>Cadastrar</button>
                    <p class="message">Já registrado? <a href="#">Faça seu login!</a></p>
                </form>
                <form class="login-form" action="Login">
                    <h1>Sistema Monitoria</h1>

                    <input name="cnpj" type="text" placeholder="Login"/>
                    <input name="senha" type="password" placeholder="Senha"/>
                    <button>Login</button>
                    <p class="message">Não registrado? <a href="#">Cadastre sua instituição agora!</a></p>
                </form>
            </div>
        </div>

        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="Login/js/index.js"></script>    
  </body>
</html>