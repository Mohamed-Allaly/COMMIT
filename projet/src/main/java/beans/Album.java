package beans;

public class Album {
	
	private int numero;
	private String nom;
	private String etat;
	
	public Album()
	{}
	
	public Album(int numero,String nom, String etat) {
		this.numero =numero;
		this.nom = nom;
		this.etat = etat;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
}
