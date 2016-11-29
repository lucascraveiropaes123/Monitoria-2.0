<%@page import="java.util.Calendar"%>
<%@page import="Bolsista.*"%>
<%@page import="Planilha.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Bolsista bolsista = (Bolsista)session.getAttribute("Bolsista");
    
    int hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    int minuto = Calendar.getInstance().get(Calendar.MINUTE);
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
                <a href="#" class="btn btn-danger square-btn-adjust">Sair</a>
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
                                <a href="ListarPlanilhas.jsp">Listar<span class="fa arrow"></span></a>
                            </li>
                            <li>
                                <a href="CadastrarPlanilha.jsp">Cadastrar<span class="fa arrow"></span></a>
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
           
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Cadastro de Planilhas</h2>   
                        <h5>As informaçoes abaixo ficarao salvas para registro das atividades no laboratorio</h5>
                    </div>
                </div>             
                <div class="row" style="margin-top: 2em">
                    <div class="col-md-3 col-sm-6 col-xs-6">           
                        <form role="form" action="CadastroPlanilha">
                            <div class="form-group">
                                <label style="margin-top: 1em;">Nome do usuário: </label>
                                <input class="form-control" name="nome_completo_visitante" placeholder="Digite o nome completo do usuário" />
                                
                                <label style="margin-top: 1em;">Documento </label>
                                <select name="documento">
                                    <option style="color:black" value="-">Selecione o tipo de documento</option>
                                    <option style="color:black" value="Identidade">Identidade</option>
                                    <option style="color:black" value="CPF">CPF</option>
                                    <option style="color:black" value="Carteirinha">Carteira Escola</option>
                                </select>
                                                                
                                <label style="margin-top: 1em;">N° do Documento </label>
                                <input class="form-control" name="num_documento" placeholder="Digite o número do documento" />
                         
                                <label style="margin-top: 1em;">Computador: </label>
                                <input class="form-control" name="computador" placeholder="Digite o número do computador" />
                         
                                <label style="margin-top: 1em;">Laboratório: </label>
                                <input class="form-control" name="laboratorio" placeholder="Digite o nome/número do laboratório" />
                                
                                <label style="margin-top: 1em;">Hora de Entrada </label>
                                
                                <label>
                                    <input class="" style="max-width: 60px;" type="number" name="hora_entrada" min="0" max="24" value="<%=hora%>"/>:
                                    <input class="" style="max-width: 60px; margin-left:-.4em" type="number" name="min_entrada" min="00" max="60" value="<%=minuto%>"/>
                                 </label>              
                                
                                <input class="but but-rc" type="submit" value="Cadastrar" style="background-color: #C90000; text: bold; padding-left:14px; color:white; margin-top: 1em;">
                            </div>
                        </form>
                    </div>
                </div>          
            </div>       
        </div>
        
        <script src="Instituicao/js/jquery-1.10.2.js"></script>
        <script src="Instituicao/js/bootstrap.min.js"></script>
        <script src="Instituicao/js/jquery.metisMenu.js"></script>
        <script src="Instituicao/js/custom.js"></script>
    </body>
</html>