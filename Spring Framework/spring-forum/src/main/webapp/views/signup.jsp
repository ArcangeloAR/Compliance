<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<sf:form modelAttribute="usuario" action="executarRegistro">
	<label for="nome">Nome:</label>
	<sf:input path="nome" />
	<label for="email">Email:</label>
	<sf:input path="email" />
	<label for="login">Nome do usuário (login):</label>
	<sf:input path="login" />
	<label for="senha">Senha:</label>
	<sf:password path="senha" />
	<input type="submit" value="Faça parte!" />
</sf:form>