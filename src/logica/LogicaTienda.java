package logica;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LogicaTienda {

	private String direccion = "C:\\Txt\\parcial.txt";

	public void ubicacionArchivo(String direccion) {
		if (!(direccion.isEmpty())) {
			this.direccion = direccion;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public List<String> cargatTxt() {
		List<String> datosGuardaos = new ArrayList();
		StringBuffer datos = new StringBuffer();
		FileReader archivoTxt = null;
		try {
			archivoTxt = new FileReader(direccion);
			archivoTxt.read();
			int valor = archivoTxt.read();
			while (valor != -1) {
				datos = datos.append((char) valor);
				valor = archivoTxt.read();
			}
		} catch (Exception e) {
		}

		datosGuardaos.add(datos.toString());

		return datosGuardaos;
	}

	public void guardarTxt(String entrada) {
		FileWriter archivoTxt = null;
		try {
			archivoTxt = new FileWriter(direccion, true);
			archivoTxt.write(entrada);
			archivoTxt.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Se produjo un error al guardar la información");
		}
	}

	public boolean validarNumero(String numero) {
		try {
			@SuppressWarnings("unused")
			int cantidad = Integer.parseInt(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getPelicula(int index) {
		String msj = null;
		if (index == 0) {
			JOptionPane.showMessageDialog(null, "Escoga una pelicula");
		} else if (index == 1) {
			msj = "Buscando a Nemo";
		} else if (index == 2) {
			msj = "Ciudad de Dios";
		} else if (index == 3) {
			msj = "Hable con ella";
		}
		return msj;
	}

	public String getHorario(int index) {
		String msj = null;
		if (index == 0) {
			JOptionPane.showMessageDialog(null, "Escoga un horario");
		} else if (index == 1) {
			msj = "Mañana";
		} else if (index == 2) {
			msj = "Tarde";
		} else if (index == 3) {
			msj = "Noche";
		}
		return msj;
	}
	
	public void abrirarchivo(){
	     try {
	            File objetofile = new File (direccion);
	            Desktop.getDesktop().open(objetofile);
	     }catch (IOException ex) {
	            System.out.println(ex);
	     }
	} 

}
