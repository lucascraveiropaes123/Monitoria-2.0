<%@page import="Bolsista.*"%>
<%@page import="Instituicao.*"%>
<%@page import="Professor.*"%>
<%@page import="Disciplina.*"%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Instituicao instituicao = (Instituicao)session.getAttribute("Instituicao");
    
    ProfessorDAO pDAO = new ProfessorDAO();
    
    List<Professor> professores = (List<Professor>)pDAO.listProfessor();
    
    BolsistaDAO bDAO = new BolsistaDAO();
    
    List<Bolsista> bolsistas = (List<Bolsista>)bDAO.listBolsista();
    
    DisciplinaDAO dDAO = new DisciplinaDAO();
    
    List<Disciplina> disciplinas = (List<Disciplina>)dDAO.listDisciplina();
    
    session.setAttribute("Disciplinas", disciplinas);
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
                        <a href="Index.jsp"><i class="fa fa-dashboard fa-3x"></i> Página inicial</a>
                    </li>
                    <li>
                        <a class="active-menu" href="#"><i class="fa fa-desktop fa-3x"></i> Cadastrar/Cadastros<span class="fa arrow"></span></a>
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
                        <a href="Relatorios.jsp"><i class="fa fa-qrcode fa-3x"></i> Relatórios</a>
                    </li>
                    <li  >
                        <a href="Tabelas.jsp"><i class="fa fa-table fa-3x" style="height: 45px; width:45px; margin-right: 10px;"></i> Tabelas salvas </a>
                    </li>
                    <li>
                        <a href="Novatabela.jsp"><i class="fa fa-edit fa-3x"></i> Nova tabela </a>
                    </li>			                   
                    <li>
                        <a href="Perfil.jsp"><i class="fa fa-square-o fa-3x"></i> Perfil</a>
                    </li>
                </ul>
            </div>
        </nav>  
           
        <div id="page-wrapper">
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">

                        <!-- Tabela de Listagem -->
                        
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Tabela de todos os monitores cadastrados e suas respectivas informações
                            </div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Coordenador</th>
                                                <th>Bolsista</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            for (Disciplina disciplina : disciplinas)
                                            {
                                                String nomeProfessor = "Nenhum";
                                                String nomeBolsista = "Nenhum";
                                                
                                                for (Bolsista bolsista : bolsistas)
                                                {
                                                    Integer id = Integer.parseInt(bolsista.getMateria());
                                                    
                                                    if(id == disciplina.getKey_disciplina())
                                                    {
                                                        nomeBolsista = bolsista.getNome_completo();
                                                    }
                                                }
                                                
                                                for (Professor professor : professores)
                                                {
                                                    Integer id = Integer.parseInt(professor.getMateria());
                                                    
                                                    if(id == disciplina.getKey_disciplina())
                                                    {
                                                        nomeProfessor = professor.getNome_completo();
                                                    }
                                                }
                                            %>
                                                
                                                <tr class="odd gradeX">
                                                    <td><%=disciplina.getNome()%></td>
                                                    <td><%=nomeProfessor%></td>
                                                    <td><%=nomeBolsista%></td>
                                                </tr>
                                            <%
                                            }
                                        %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    <!--Fim da Tabela de Listagem -->
                    </div>
                </div>       
                <a href="ListaSelecaoDisciplinas.jsp">
                    <div class="col-md-4 col-sm-11 col-xs-11">
                        <div class="panel panel-primary text-center no-boder bg-color-green">
                            <div class="panel-body">
                                <br>
                                <i class="fa fa-pencil" style="font-size: 2.5em"></i>
                                <br><br>
                            </div>
                            <div class="panel-footer back-footer-green">
                                <b style="font-size: 1.5em">Editar</b>
                            </div>
                        </div>
                    </div>
                </a>
            </div>       
        </div>
        
        <script src="Instituicao/js/jquery-1.10.2.js"></script>
        <script src="Instituicao/js/bootstrap.min.js"></script>
        <script src="Instituicao/js/jquery.metisMenu.js"></script>
        <script src="Instituicao/js/morris/raphael-2.1.0.min.js"></script>
        <script src="Instituicao/js/morris/morris.js"></script>
        <script src="Instituicao/js/custom.js"></script>
    </body>
</html>