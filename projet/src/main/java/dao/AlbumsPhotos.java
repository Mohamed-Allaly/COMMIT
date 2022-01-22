package dao;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import beans.Album;
import beans.Photos;

public class AlbumsPhotos {

		private static final ArrayList<Photos> photos = new ArrayList<Photos>();
		private static final ArrayList<Album> albums = new ArrayList<Album>();
		private static final ArrayList<Integer> ids = new ArrayList<Integer>();
		
		
		public static ArrayList<Photos> lister(int num){
			
			//chargement de driver
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//connexion de la base 
			
			Connection connexion =null;
			PreparedStatement statement = null;
			ResultSet resultat = null;
			
			try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
			statement = connexion.prepareStatement("SELECT id,titre,taille,description,date_creation,date_update,image,image_file_name,numero_album FROM photos where numero_album=? ;");
			
			statement.setInt(1, num);
			
			resultat = statement.executeQuery();
			
			while(resultat.next())
			{
				int id = resultat.getInt("id");
				String titre =resultat.getString("titre");
				double taille =resultat.getDouble("taille");
				String description =resultat.getString("description");
				Date date_creation =resultat.getDate("date_creation");
				Date date_update =resultat.getDate("date_update");
				InputStream image = resultat.getBinaryStream("image");
				String file_name=resultat.getString("image_file_name");
				String numero = resultat.getString("numero_album");
				
				Photos photo = new Photos(id,titre,description,file_name,taille,date_creation,date_update,image,Integer.parseInt(numero));
				
				
				photos.add(photo);
				
			}
			
			}catch( SQLException e)
			{
				
			}
			//Fermeture de connexion
			finally
			{
			  try {
				  if (resultat!=null)
					resultat.close();
				  if(statement!=null)
					statement.close();
				  if(connexion!=null)
					connexion.close();
			  }catch(SQLException sql)
			  {
				  
			  }
			}
			
			
			return photos;
		}
		
public static ArrayList<Album> ListerALbums(){
			
			//chargement de driver
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//connexion de la base 
			
			Connection connexion =null;
			Statement statement = null;
			ResultSet resultat = null;
			
			try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT numero,nom,etat FROM albums ;");
			
			while(resultat.next())
			{
				int numero = resultat.getInt("numero");
				String nom = resultat.getString("nom");
				String etat = resultat.getString("etat");
				Album album = new Album(numero,nom,etat);
				
				albums.add(album);
				
			}
			
			
			}catch( SQLException e)
			{
				
			}
			//Fermeture de connexion
			finally
			{
			  try {
				  if (resultat!=null)
					resultat.close();
				  if(statement!=null)
					statement.close();
				  if(connexion!=null)
					connexion.close();
			  }catch(SQLException sql)
			  {
				  
			  }
			}
			
			
			return albums;
		}

		
		public static void AjoutAlbum(String nom,String etat)
		{
			//chargement de driver
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//connexion de la base 
			
			Connection connexion =null;
			PreparedStatement statement = null;
			
			try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
			statement =connexion.prepareStatement("insert into albums (nom,etat) value (?,?);");
			statement.setString(1, nom);
			statement.setString(2, etat);
		    statement.executeUpdate();
			
			
			statement.close();
			connexion.close();
		}catch (SQLException sql)
			{
				
			}
			return;
	}
		
		public static void AjoutPhoto(String titre, String description,String filename,int numero_album)
		
		{
			//chargement de driver
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//connexion de la base 
			
			Connection connexion =null;
			PreparedStatement statement = null;
			ResultSet resultat = null;
			
			try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
			
			File image = new File(filename);
			FileInputStream istreamImage = new FileInputStream(image);
			
			int taille = (int) image.length();
			
			// pour dernier modification 
			String pattern = "yyyy-MM-dd hh:mm";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date_update =simpleDateFormat.format(new Date(image.lastModified()));
			
			statement =connexion.prepareStatement("insert into photos (id,titre,taille ,description ,date_creation ,date_update , image ,image_file_name,numero_album) value (0,?,?,?,now(),?,?,?,?);");
			
			statement.setString(2, titre);
			statement.setInt(3, taille);
			statement.setString(4, description);
			statement.setString(6, date_update);
			statement.setBinaryStream(7, istreamImage, taille);
			statement.setString(8, filename);
			statement.setInt(9, numero_album);
			
			statement.executeUpdate();
			
		}catch(SQLException sql)
			{
			
			}
		catch(FileNotFoundException ex)
			{
			
			}
			finally
			{
			  try {
					resultat.close();
					statement.close();
					connexion.close();
			  }catch(SQLException sql)
			  {
				  
			  }
			}
			
		}
		
	public static ArrayList<Integer> get()
		{
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//connexion de la base 
			
			Connection connexion =null;
			Statement statement = null;
			ResultSet resultat = null;
			
			try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
			statement = connexion.createStatement();
			resultat = statement.executeQuery("select numero from albums ;");
			
			while(resultat.next())
			{
				int numero = resultat.getInt("numero");
				ids.add(numero);
			}
			
			
		}catch(SQLException sql)
			{
			
			}
			//Fermeture de connexion
			finally
			{
			  try {
				  if (resultat!=null)
					resultat.close();
				  if(statement!=null)
					statement.close();
				  if(connexion!=null)
					connexion.close();
			  }catch(SQLException sql)
			  {
				  
			  }
			}
			
			return ids;
		
		}

	
	public static boolean supprimer(int num) {
		
		//chargement de driver
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//connexion de la base 
		
		Connection connexion =null;
		PreparedStatement statement = null;
		
		try {
		connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
		statement = connexion.prepareStatement("delete from albums where numero=?;");
		
		statement.setInt(1,num);
		statement.executeUpdate();
		
		
	}catch (SQLException sql)
		{
			
		}
		finally
		{
			try {
			statement.close();
			connexion.close();
			}catch(SQLException sql)
			{
				
			}
			
		}
		return true;
			
}
	
	
	public static boolean modifier(Album alb)
	{
		for (Album album : albums)
		{
			if(album.getNumero()== alb.getNumero())
			{
				
				album.setNom(alb.getNom());
				album.setEtat(alb.getEtat());
				return true;
			}
		}
		return false;
	}
	
	

	public static Album get(int numero) {
			
			for(Album album: albums)
			{
				if (album.getNumero()== numero)
				{
					return album;
				}
			}
			return null;
		}

	
	public static boolean supprimerPhoto(int id) {
		//chargement de driver
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//connexion de la base 
				
				Connection connexion =null;
				PreparedStatement statement = null;
				
				try {
				connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Albums","root","");
				statement = connexion.prepareStatement("delete from photos where id=?;");
				
				statement.setInt(1,id);
				statement.executeUpdate();
				
				
			}catch (SQLException sql)
				{
					
				}
				finally
				{
					try {
					statement.close();
					connexion.close();
					}catch(SQLException sql)
					{
						
					}
					
				}
				return true;
					
		}

	public static boolean modifierphoto(Photos photo) {
		for (Photos photos : photos)
			{
				if(photos.getId()== photo.getId())
				{
					
					photos.setTitre(photo.getTitre());
					photos.setDescription(photo.getDescription());
					photos.setNumero(photo.getNumero());
					return true;
				}
			}
			return false;
	}
		
	
		
}
