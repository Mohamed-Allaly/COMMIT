<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Abums photo utilisateur</title>
<link rel="stylesheet" href ="css/style.css">
</head>
<body>
	
	<div id="entete"> Ajoutez une photo </div>

<div id="corps">
	<form method="post" enctype="multipart/form-data" >
	   <div class="formItem">
	   		<label for="titre"> titre </label>
	   		<input id="titre" name="titre" type="text" required="required">
	   </div>
	   
	   <div class="formItem">
	   		<label for="description"> description </label>
	   		<textarea id="description" name="description"></textarea>
	   </div>
	   
	   <div class="formItem">
	   		<label for="image"> Image </label>
	   		<input id="image" name="image" type="file" required="required">
	   </div>
	   
	   <div class="formItem">
	   		<label for="numero"> numero d'album </label>
	   		<select id="numero" name="num" form="carform">
	   			<c:forEach items="${ids}" var ="id">
	   				<option> <c:out value="${id }"/> </option>
	   			</c:forEach>
	   			
	   		</select>
	   </div>
	   
	   <div class="formItem">
		<label for="valider"></label>
		<input id ="valider" type="submit" value="valider">
	</div>
	</form>


</div>


<c:import url="pied.jsp"/>