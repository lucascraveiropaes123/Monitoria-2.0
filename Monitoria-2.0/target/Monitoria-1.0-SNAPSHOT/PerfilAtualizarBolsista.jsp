<%@page import="Bolsista.*"%>
<%@page import="Planilha.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Bolsista bolsista = (Bolsista)session.getAttribute("Bolsista");
    
    System.out.println("Nome:"+bolsista.getPrimeiro_nome());
    System.out.println("Sobrenome:"+bolsista.getSobrenome());
    System.out.println("Materia:"+bolsista.getMateria());
    System.out.println("Senha"+bolsista.getSenha());
%>


﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%=bolsista.getNome_completo()%></title>

    <link href="Instituicao/css/bootstrap.css" rel="stylesheet" />
    <link href="Instituicao/css/font-awesome.css" rel="stylesheet" />
    <link href="Instituicao/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <link href="Instituicao/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
        
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../index.jsp"><%=bolsista.getPrimeiro_nome()%></a> 
            </div>
            <div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
                <a href="#" class="btn btn-danger square-btn-adjust">Sair</a>
            </div>
        </nav>   
            
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li class="text-center">
                        <img src="Instituicao/img/find_user.png" class="user-image img-responsive"/>
                    </li>	
                    <li>
                        <a class="active-menu"  href=""><i class="fa fa-dashboard fa-3x"></i> Página inicial</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-desktop fa-3x"></i> Planilhas<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="ListarPlanilhas.jsp">Listar</a>
                            </li>
                            <li>
                                <a href="CadastrarPlanilha.jsp">Cadastrar</a>
                            </li>
                            <li>
                                <a href="ListaSelecaoPlanilha.jsp">Atualizar</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a  href="Instituicao/Relatorios.jsp"><i class="fa fa-qrcode fa-3x"></i> Relatórios</a>
                    </li>           
                    <li>
                        <a  href="Instituicao/Perfil.jsp"><i class="fa fa-square-o fa-3x"></i> Perfil</a>
                    </li>
                </ul>
            </div>
        </nav> 
           
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="col-md-4 col-sm-12 col-xs-12" >
                    <form role="form" action="AtualizarBolsista">
                        <div class="form-group">
                            <label style="margin-top: 1em;">Primeiro Nome: </label>
                            <input class="form-control" name="primeiroNome" value="<%=bolsista.getPrimeiro_nome()%>" />

                            <label style="margin-top: 1em;">Sobrenome: </label>
                            <input class="form-control" name="sobrenome" value="<%=bolsista.getSobrenome()%>" />

                            <label style="margin-top: 1em;">Matéria: </label>
                            <input class="form-control" name="materia" value="<%=bolsista.getMateria()%>" disabled/>

                            <label style="margin-top: 1em;">Login: </label>
                            <input class="form-control" name="login" value="<%=bolsista.getLogin()%>"/>

                            <label style="margin-top: 1em;">Senha: </label>
                            <input class="form-control" type="password" name="senha" placeholder="Digite sua senha novamente"/>

                            <input class="but but-rc" type="submit" value="Atualizar" style="background-color: #C90000; text: bold; padding-left:14px; color:white; margin-top: 1em;">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        <script src="Instituicao/js/jquery-1.10.2.js"></script>
        <script src="Instituicao/js/bootstrap.min.js"></script>
        <script src="Instituicao/js/jquery.metisMenu.js"></script>
        <script src="Instituicao/js/custom.js"></script>
    </body>
</html>