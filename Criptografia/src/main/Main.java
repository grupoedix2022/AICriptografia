package main;


import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		boolean continuar = true;
		boolean sentenciaCheck = true;
		int i = 0;
		String in;
		Scanner scan = new Scanner(System.in);
		CifradorSim cifrador = new CifradorSim();
		String sentencia; 
		String sentenciaCifrada=null;
		String sentenciaDescifrada=null;
		String nombre, pass;
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u1 = new Usuario("admin", "admin");
		Usuario u2 = new Usuario("monkey", "1234");
		Usuario u3 = new Usuario("user", "asdf");
		Usuario usuario;
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		
		do {
			System.out.println("Nombre de usuario:");
			nombre = scan.nextLine();
			usuario=checkNombre(nombre, usuarios);
			if (usuario!=null){				
				System.out.println("Contraseña: ");
				pass=scan.nextLine();
				if (usuario.checkPass(pass)) {
					System.out.println("Contraseña correcta");
					do {
						//Iniciamos menú
						System.out.println("MENU");
						System.out.println("1. Encriptar frase");
						System.out.println("2. Desencriptar frase");
						System.out.println("0. Salir");
						System.out.println("");		
						in = scan.nextLine();
						switch(Integer.parseInt(in)) {
						
						//Salir
						case 0:
							continuar = false;
							break;			
						case 1:
							if(sentenciaCheck){					
								System.out.println("Introducir sentencia");
								sentencia=scan.nextLine();
								sentenciaCifrada=cifrador.cifrador(sentencia);
								sentenciaCheck=false;
								System.out.println("Su sentencia es: " + sentencia);
								System.out.println("Su sentencia encriptada es: " + sentenciaCifrada);
							}else{
								System.out.println("Ya existe una sentencia");
							}
							break;	
						case 2:
							if (sentenciaCifrada != null) {
								System.out.println("Su sentencia encriptada es: " + sentenciaCifrada);
								System.out.println("Su sentencia desencriptada es: " );
								sentenciaDescifrada = cifrador.descifrador(sentenciaCifrada);					
								System.out.println(sentenciaDescifrada);
								sentenciaCifrada=null;
								sentenciaCheck=true;
							}else{
								System.out.println("No existe sentencia");
							}
							break;		
							
						default:
							System.out.println("Instrucción invalida");
						break;			
						
						}				
					}while(continuar);
				}else{
					System.out.println("Contraseña Incorrecta");
					i++;
				}
			}else {
				System.out.println("Usuario Incorrecto");
			}
		}while(i<3 && continuar);
	//Cerramos scan	
	scan.close();
	System.out.println("Fin del programa");
		
							
	}
	
	public static Usuario checkNombre(String nombre, List<Usuario> usuarios){
		for(Usuario u:usuarios){
			if(nombre.equalsIgnoreCase(u.getNombre())){
				return u;
			}
		}
				return null;
			
	}
		
	
}
