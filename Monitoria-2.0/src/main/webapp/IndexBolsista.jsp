<%@page import="Bolsista.*"%>
<%@page import="Planilha.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Bolsista bolsista = (Bolsista)session.getAttribute("Bolsista");
%>


﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%=bolsista.getNome_completo()%></title>
	<!-- BOOTSTRAP STYLES-->
    <link href="Instituicao/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="Instituicao/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="Instituicao/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="Instituicao/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
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
                <form role="form" action="Logout">
                    <input class="but btn-danger square-btn-adjust" type="submit" value="Sair" style="padding: .5em; padding-left: .9em; padding-right: .9em; margin-top: -0.2em;">
                </form>
            </div>
        </nav>   
           <!-- /. NAV TOP  -->
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
                        <a  href="PerfilBolsista.jsp"><i class="fa fa-square-o fa-3x"></i> Perfil</a>
                    </li>
                </ul>
            </div>
        </nav> 
           
        <div id="page-wrapper" >
            <div id="page-inner">
                <a href="">
                    <div class="col-md-6 col-sm-12 col-xs-12" >
                        <div class="panel panel-primary text-center no-boder bg-color-green green">
                            <div class="panel-body">
                                <br>
                                <i class="fa fa-file-text" style="font-size: 5em"></i>
                                <br><br>
                            </div>
                            <div class="panel-footer back-footer-green">
                                <b style="font-size: 1.5em">Relatórios</b>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-red red">
                            <div class="panel-body">
                                <br>
                                <i class="fa fa-cogs" style="font-size: 5em"></i>
                                <br><br>
                            </div>
                            <div class="panel-footer back-footer-red">
                                <b style="font-size: 1.5em">Atualização</b>
                            </div>
                        </div>
                    </div>
                </a>
                <a href="">
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="panel panel-primary text-center no-boder bg-color-red red">
                            <div class="panel-body">
                                <br>
                                <i class="fa fa-user" style="font-size: 5em"></i>
                                <br><br>
                            </div>
                            <div class="panel-footer back-footer-red">
                                <b style="font-size: 1.5em">Meu Perfil</b>
                            </div>
                        </div>
                    </div>
                </a>
                <br>
                <a href="">
                    <div class="col-md-6 col-sm-12 col-xs-12" >
                        <div class="panel panel-primary text-center no-boder bg-color-green green">
                            <div class="panel-body">
                                <br>
                                <i class="fa fa-folder-o" aria-hidden="true" style="font-size: 5em"></i>
                                <br><br>
                            </div>
                            <div class="panel-footer back-footer-green">
                                <b style="font-size: 1.5em">Dados Cadastrados</b>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        
        <script src="Instituicao/js/jquery-1.10.2.js"></script>
        <script src="Instituicao/js/bootstrap.min.js"></script>
        <script src="Instituicao/js/jquery.metisMenu.js"></script>
        <script src="Instituicao/js/custom.js"></script>
    </body>
</html>