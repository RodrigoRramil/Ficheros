package ficheros;

import java.io.File;
import java.io.IOException;

public class AccesoFichero {

	public static void crearFichero() {

		File carpeta = new File ("C:\\carpetaFichero");

		if (!carpeta.exists()) {
			
			System.out.println("La carpeta no existe");
			boolean ok = carpeta.mkdir();
			if (ok)
				System.out.println("Se ha creado una nueva carpeta");
			else
				System.out.println("La carpeta no ha podido crearse");
		}
		else {
			System.out.println("La carpeta existe");
			informaciónCarpeta(carpeta);

			try {
			String[] contenido = carpeta.list();
			System.out.println("Archivos o carpetas que contiene: " + contenido.length);
			for (String nombre : contenido) {
				File f = new File(carpeta.getPath(), nombre);
				if (f.isDirectory()) {
					System.out.println(nombre + ", " + " carpeta");
				}
				else {
					System.out.println(nombre + ", " + " fichero, " + f.length() + " bytes");
				}				
			}
			} catch (NullPointerException e) {
				System.out.println("ERROR al listar el contenido de la carpeta");
			}

		}
		
		File archivo =new File ("C:\\carpetaFichero\\fichero.txt");
		if (!archivo.exists()) {			
			System.out.println("El fichero no existe");
			try {
			archivo.createNewFile();
			System.out.println("Se ha creado un nuevo fichero");
			} catch (IOException e){
				System.out.println("ERROR de creación del fichero");
			}
		}
		else {
			System.out.println("El ficheto existe");
			informacionFichero(archivo);
		}
	}

	public static void informaciónCarpeta(File carpeta) {
		
		System.out.println("¿Tiene permiso de escritura? " + carpeta.canWrite());
		System.out.println("Nº de bytes que ocupa: " + carpeta.length());
		System.out.println("Nombre de la carpeta: " + carpeta.getName());
		System.out.println("Ruta: " + carpeta.getPath());
		System.out.println("¿Es una carpeta oculta? " + carpeta.isHidden());
		System.out.println("¿Esta permitida la escritura? " + carpeta.canWrite());
		System.out.println("¿Esta permitida la lectura? " + carpeta.canRead());
		System.out.println("\n");

	}

	public static void informacionFichero(File archivo) {
		
		System.out.println("Nº de bytes que ocupa: " + archivo.length());
		System.out.println("Nombre de archivo: " + archivo.getName());
		System.out.println("Ruta: " + archivo.getPath());
		System.out.println("¿Es un fichero oculto? " + archivo.isHidden());
		System.out.println("¿Esta permitida la escritura? " + archivo.canWrite());
		System.out.println("¿Esta permitida la lectura? " + archivo.canRead());
	}
	
	
	

}
