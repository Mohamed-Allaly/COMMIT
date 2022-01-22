<c:import url="head.jsp"/>

	<div id="menu">
		<ul>
			<li><a href="/projet/acceuil">Acceuil</a></li>
			<li><a href="/projet/add"> AjouterPhoto</a></li>
			<li><a href="/projet/album">AjouterAlbum</a></li>
			<li><a href="/projet/deconnexion">Deconnection</a></li>
		</ul>
	</div>
	
	<div id="corps">
		<h1 id="titre-principale" style="text-align:center"> Liste des Albums </h1>
		<c:choose>
			<c:when test="${empty Albums }"><p>vous n'avez pas le moment des albums</p></c:when>
			<c:otherwise>
			  <table>
				<tr>
					<th> Numero </th>
					<th> Nom </th>
					<th> Etat</th>
					<th colspan="2"> Actions </th>
					
				</tr>
				  <c:forEach items="${Albums}" var="album">
					<tr>
					
					<td> <c:out value="${album.numero}" /> </td>
					<td> <a href="/projet/lister?numero=${album.numero }" ><c:out value="${album.nom }"/></a> </td>
					<td> <c:out value="${album.etat }"  /> </td>
					<td> <a href ="/projet/delete?numero =${album.numero }"> Supprimer </a></td>
					<td> <a href ="/projet/update?numero=${album.numero }"> Modifier</a></td>
					
					</tr>
			   </c:forEach>
			 </table>
		   </c:otherwise>
		</c:choose>
	
	</div>
<c:import url="pied.jsp"></c:import>