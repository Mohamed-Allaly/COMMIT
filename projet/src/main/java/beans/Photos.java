package beans;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class Photos {
	private int id ;
	private String titre,description,file_name;
	public Date date_creation,date_update;
	private double taille;
	private int numero;
	private InputStream image;
	
	public Photos()
	{
	}
	
	public Photos(int id, String titre,String description,String file_name, double taille,Date date_creation,Date date_update, InputStream image,int numero) {
		super();
		this.id = id;
		this.titre = titre;
		this.description=description;
		this.file_name=file_name;
		this.taille = taille;
		this.date_creation=date_creation;
		this.date_update = date_update;
		this.image = image;
		this.numero=numero;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_Cration) {
		this.date_creation = date_Cration;
	}

	public Date getDate_update() {
		return date_update;
	}

	public void setDate_update(Date date_update) {
		this.date_update = date_update;
	}

	public  int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
}
