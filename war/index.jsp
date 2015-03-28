<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>RSSFeed-Leitor</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/normalize.css" rel="stylesheet" media="screen">

</head>
<body>
  <div class="container">

	<c:import url="commons/header.jsp?opt=index" />

    <div class="row">
      <div class="col-md-4">
        <div class="list-group">
  			<c:forEach var="category" items="${categories}">
            	<a href="#" class="list-group-item active">${category.title} <span class="badge">14</span></a>
  			</c:forEach>
        </div>
      </div>
      <div class="col-md-8">

        <div class="list-group">
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">Arquitetura de microserviços ou monolítica?</h4>
            <p class="list-group-item-text">Dentro da Caelum, temos a experiência de termos criado várias aplicações web, seja para nós mesmos, para clientes ou para iniciativas nossas. Uma dessas aplicações de vital importância para nós é o nosso ERP. É um […]</p>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">Acessando múltiplos bancos de dados com JPA e CDI</h4>
            <p class="list-group-item-text">É bem comum que uma aplicação precise acessar vários bancos de dados para prover suas funcionalidades. Um exemplo clássico dessa situação encontramos em empresas que possuem muitos sistemas, e para evitar ter tabelas e registros […]</p>
          </a>
          <a href="#" class="list-group-item list-group-item-info">
            <h4 class="list-group-item-heading">Testes de Aceitação e suas boas práticas</h4>
            <p class="list-group-item-text">Testar aplicações web não é lá tão simples. A maioria de nós apela para testes de unidade. Afinal, eles são fáceis e rápidos de serem escritos, e quando o sistema está bem modelado, eles te […]</p>
          </a>
          <a href="#" class="list-group-item list-group-item-info">
            <h4 class="list-group-item-heading">Mais uma vez… TDD não é bala de prata!</h4>
            <p class="list-group-item-text">Essa semana, o DHH, o famoso criador do Ruby on Rails, fez um post polêmico sobre o assunto, entitulado “TDD is Dead, Long Live Testing”, que em uma tradução livre, é algo como “TDD está morto, […]</p>
          </a>
          <a href="#" class="list-group-item list-group-item-info">
            <h4 class="list-group-item-heading">Voando nas nuvens com VRaptor 4: Heroku e OpenShift</h4>
            <p class="list-group-item-text">Hospedar sua aplicação numa nuvem é uma alternativa cada vez mais interessante. Os serviços são cada vez mais baratos, versáteis e fáceis de usar. Esse cenário fica ainda mais interessante quando podemos usar um framework […]</p>
          </a>
        </div>
      </div>
    </div>





  </div> <!-- /container -->



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
