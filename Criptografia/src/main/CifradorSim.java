package main;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CifradorSim{
	
	SecretKey codigoSecreto;
	Cipher cifrador;
	KeyGenerator generador;
	
	public CifradorSim(){		
		try {
			generador = KeyGenerator.getInstance("AES");
			codigoSecreto = generador.generateKey();
			 cifrador = Cipher.getInstance("AES");
			 cifrador.init(Cipher.ENCRYPT_MODE, codigoSecreto);
		}catch (GeneralSecurityException gse) {
				System.out.println("Algo ha fallado.." + gse.getMessage());
				gse.printStackTrace();
		}
	}
	
	public String cifrador(String pass){
		try {
			byte[] bytesPass = pass.getBytes();
			byte[] bytesPassCifrado = cifrador.doFinal(bytesPass);
			String mensajeCifrado = new String(bytesPassCifrado);
			return mensajeCifrado;
		}catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
			return null;
		}
		
	}
	
	public String descifrador(String pass) {
		try {
			byte[] bytesPass= pass.getBytes();
			cifrador.init(Cipher.DECRYPT_MODE, codigoSecreto);
			byte[] bytesPassDescifrado = cifrador.doFinal(bytesPass);
			return new String(bytesPassDescifrado);
		}catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
			return null;
		}
	}
	

}
