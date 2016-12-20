<%@page import="Instituicao.InstituicaoDAO"%>
<%@page import="Instituicao.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Instituicao instituicao = (Instituicao)session.getAttribute("Instituicao");
    InstituicaoDAO iDAO = new InstituicaoDAO();
  
    int sizePassword = instituicao.getSenha().length(), i;
    
    String senha = "*";
    
    for(i=0; i<sizePassword; i++)
    {
        if(i==0)
            senha = "*";
        else
            senha += "*";
    }
    
    int professores = iDAO.numProfessores(instituicao.getCnpj());
    int bolsistas = iDAO.numBolsistas(instituicao.getCnpj());
    
%>


﻿<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%=instituicao.getNome()%></title>
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
                <a class="navbar-brand" href="../index.jsp"><%=instituicao.getNome()%></a> 
            </div>
            <div style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
                <form action="Logout">
                    <button type="submit" class="btn btn-danger square-btn-adjust">Sair</button>
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
                    </li><li>
                        <a href="#"><i class="fa fa-desktop fa-3x"></i> Cadastrar/Cadastros<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#">Professores<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="ListarProfessores.jsp">Listar</a>
                                    </li>
                                    <li>
                                        <a href="CadastrarProfessor.jsp">Cadastrar</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Bolsistas<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="ListarBolsistas.jsp">Listar</a>
                                    </li>
                                    <li>
                                        <a href="CadastrarBolsista.jsp">Cadastrar</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Disciplina<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="ListarDisciplinas.jsp">Listar</a>
                                    </li>
                                    <li>
                                        <a href="CadastrarDisciplina.jsp">Cadastrar</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a  href="Relatorios.jsp"><i class="fa fa-qrcode fa-3x"></i> Relatórios</a>
                    </li>
                    <li  >
                        <a  href="Planilhas.jsp"><i class="fa fa-table fa-3x" style="height: 45px; width:45px; margin-right: 10px;"></i> Planilhas </a>
                    </li>               
                    <li>
                        <a  href="PerfilInstituicao.jsp"><i class="fa fa-square-o fa-3x"></i> Perfil</a>
                    </li>
                </ul>
            </div>
        </nav> 
           
        
           
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="col-md-4 col-sm-12 col-xs-12" >
                    <span>
                        Empresa: <%=instituicao.getNome()%><br><br>
                        CNPJ: <%=instituicao.getCnpj()%><br><br>
                        N° Cartão: <%=instituicao.getNum_cartao()%><br><br>
                        e-Mail: <%=instituicao.getEmail()%><br><br>
                        Senha: <%=senha%><br><br>
                        N° de Professores: <%=professores%><br><br>
                        N° de Bolsistas: <%=bolsistas%><br><br>
                    </span>
                    <br><br>
                    <a href="PerfilAtualizarInstituicao.jsp"><button class="btn btn-primary">Atualizar Dados</button></a>
                    <a href="DeletarInstituicao"><button class="btn btn-primary">Deletar Instituição</button></a>
                </div>
            </div>
        </div>
           
        <script src="Instituicao/js/jquery-1.10.2.js"></script>
        <script src="Instituicao/js/bootstrap.min.js"></script>
        <script src="Instituicao/js/jquery.metisMenu.js"></script>
        
        <script src="Instituicao/js/custom.js"></script>
    </body>
</html>