<%@page import="java.util.List"%>
<%@page import="Bolsista.*"%>
<%@page import="Planilha.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Bolsista bolsista = (Bolsista)session.getAttribute("Bolsista");
    
    PlanilhaDAO pDAO = new PlanilhaDAO();
    
    List <Planilha> planilhas = (List<Planilha>)pDAO.listPlanilha();
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
           
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <h2>Planilhas diárias</h2>   
                        <h5>As informaçoes abaixo são relacionadas às atividas efetuadas nas dependências da escola</h5>
                    </div>
                </div>             
                <div class="row" style="margin-top: 2em">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Algum texto
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table" style="max-width:100%; overflow: auto;">
                                        <thead>
                                            <tr>
                                                <th style="text-align: center">Entrada</th>
                                                <th style="text-align: center">Saida</th>
                                                <th style="text-align: center">Nome</th>
                                                <th style="text-align: center">Computador</th>
                                                <th style="text-align: center">Laboratorio</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            for (Planilha planilha : planilhas)
                                            {
                                                String saida = "";
                                                
                                                System.out.println(planilha.getVisitante());
                                                System.out.println("." + planilha.getHora_saida()+".");
                                                System.out.println("." + planilha.getMin_saida()+".");
                                                
                                                System.out.println("0");
                                                        
                                                if(planilha.getHora_saida() == null && planilha.getMin_saida() == null)
                                                {
                                                    saida = "";
                                                    System.out.println("1");
                                                }
                                                else
                                                {
                                                    saida = planilha.getHora_saida() + "h" + planilha.getMin_saida();
                                                    System.out.println("2");
                                                }
                                                System.out.println("3");
                                                String entrada = planilha.getHora_entrada() + "h" + planilha.getMin_entrada();
                                                System.out.println("4");
                                        %>
                                            <tr>
                                                <td style="text-align: center"><%=entrada%></td>
                                                <td style="text-align: center"><%=saida%></td>
                                                <td style="text-align: center"><%=planilha.getVisitante()%></td>
                                                <td style="text-align: center"><%=planilha.getComputador()%></td>
                                                <td style="text-align: center"><%=planilha.getLaboratorio()%></td>
                                            </tr>
                                        <%
                                            System.out.println("5");
                                            }

                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
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