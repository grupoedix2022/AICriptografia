package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario{
	
	String pass;
	String nombre;
	
	
	public Usuario(String nombre, String pass) {
		byte[] passBytes;
		try {
			this.nombre=nombre;			
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(pass.getBytes());
			passBytes = md.digest();
			this.pass = new String(passBytes);
		}catch (NoSuchAlgorithmException e) {
			System.out.println("Algo fue mal");
		}
							
	}
	
	public boolean checkPass(String pass){
		byte[] passBytes;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(pass.getBytes());
			passBytes = md.digest();
			pass = new String(passBytes);
			if (pass.equals(this.pass)){
				return true;
			}else {
				return false;
			}
		}catch (NoSuchAlgorithmException e) {
			System.out.println("Algo fue mal");
			return false;
		}
	}

	public String getPass() {
		return pass;
	}

	public String getNombre() {
		return nombre;
	}
	
	

}
