  <%@ page import ="beans.Photos , java.util.ArrayList" %>
  <c:import url="head.jsp"/>
  	
  	<div id ="corps">
	<form  method="post">
	  <div class="formItem">
		<label for="login"> Login </label> 
		<input id="login" name="login" type="text" required="required">
	 </div>
	 <div class="formItem">
		<label for="password">	password </label>
		<input id="password" name="password" type="password" required="required">
	</div>
	<div class="formItem">
		<label for="valider"></label>
		<input id ="valider" type="submit" value="valider">
	</div>
	</form>
</div>
		
		<div >
			<h1 id="albums-photos"> LES Albums Public </h1>
			<table>
			<tr>
				<th> nom </th>
				
			</tr>
				
				<c:forEach items="${album}" var="albums"> 
					
				<tr>
				   <td> <c:out value="${albums.nom}"></c:out> </td>
			 </tr>
			 
				</c:forEach>
				
			</table>
		
		</div>
	
	<c:import url="pied.jsp"/>
	
