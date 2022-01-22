<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>  Abums photo utilisateur</title>
<link rel="stylesheet" href ="css/style.css">
</head>
<body>
	<div id="entete">Ajoutez un album</div>
	
<div id="corps"> 
		
	 <form method="post">
	   <div class="formItem">
	   		<label for="nom"> Nom </label>
	   		<input id="nom" name="nom" type="text" value="${albums.nom }">
	   </div>

	   <p style="text-align:center ; text-transform: uppercase"> etat d'album </p>
	   <div class="formItem">
	   		<label for="etat"> Public</label>
	   		<input id="etat" name="etat" type="radio" value ="${albums.etat }" checked="checked">
	   </div>
	   
	   <div class="formItem">
	   		<label for="etat">Prive </label>
	   		<input id="etat" name="etat" type="radio" value ="prive" checked="checked">
	   </div>
	   
	   <div class="formItem">
		<label for="valider"></label>
		<input id ="valider" type="submit" value="valider">
	</div>
	</form>
 </div>

<c:import url="pied.jsp"/>