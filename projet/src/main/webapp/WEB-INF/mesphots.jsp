<c:import url="head.jsp"/>
	
	<div id="corps">
		<h1 id="titre-principale"> Mes Photos </h1>
		<c:choose>
			<c:when test="${empty photos }"><p>vous n'avez pas le moment des photos</p></c:when>
			<c:otherwise>
			  <table>
				<tr>
					<th> id </th>
					<th> titre </th>
					<th> taille</th>
					<th>description</th>
					<th>date_creation</th>
					<th>date_update</th>
					<th> image</th>
					<th>image_file_name</th>
					<th>numero_albums</th>
					<th colspan="2">Action</th>
				</tr>
				  <c:forEach items="${photos}" var="photo">
					<tr>
					
					<td> <c:out value="${photo.id}" /> </td>
					<td> <c:out value="${photo.titre}" /> </td>
					<td> <c:out value="${photo.taille }"/></td>
					<td> <c:out value="${photo.description }"  /> </td>
					<td> <c:out value="${photo.date_creation }"  /> </td>
					<td> <c:out value="${photo.date_update }"  /> </td>
					<td> <img alt="" src=<c:out value="${photo.image }"/>/> </td>
					<td> <c:out value="${photo.file_name }"  /> </td>
					<td> <c:out value="${photo.numero }"/> </td>
					</tr>
			   </c:forEach>
			 </table>
		   </c:otherwise>
		</c:choose>
	
	</div>
	
 	<c:import url="pied.jsp"/>