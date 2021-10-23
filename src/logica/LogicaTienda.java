package logica;

import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public final class LogicaTienda {
	@SuppressWarnings("unused")
	private double precio = 0;

	public int calcularAsignarPrecio(String producto) {
		int precio = (producto.length() * 1000);
		return precio;
	}

	private String direccion = "C:\\Txt\\datosGuardados.txt";
	private String direccionCopia = "C:\\Txt\\datosGuardados.txt";
	private int cantPeli = 4, indice = 0;

	public int setCantidaPelicula(String cantidad) {

		boolean valido = validarNumero(cantidad);

		if (valido == true
				&& !(cantidad.contains(".") || cantidad.contains(","))) {
			cantPeli = Integer.parseInt(cantidad);
			return (cantPeli + 1);
		} else {
			JOptionPane.showMessageDialog(null,
					"Error! intente nuevamente y ingrese un dato valido");
			cantPeli = 0;
			return 0;
		}
	}

	private String[] peliculas = new String[(cantPeli + 1)];
	private String peliRetor;

	@SuppressWarnings("unused")
	public String setPelicula() {
		peliculas[0] = "";
		for (int i = 1; i < peliculas.length; i++) {
			++indice;
			peliRetor = JOptionPane
					.showInputDialog("Ingrese el nombre de la pelicula "
							+ indice);
			peliculas[indice] = peliRetor;
			return peliRetor;
		}
		return "";
	}

	public String getPelicula2(int index) {
		String peli = "";
		for (int i = 1; i < peliculas.length; i++) {
			if (peliculas[i] == peliculas[index]) {
				peli = peliculas[index];
				break;
			}
		}
		return peli;
	}

	/*****************************************************************************************/

	public void ubicacionArchivo(String direccion) {
		if (direccion == null) {
			JOptionPane.showMessageDialog(null, "Saliendo del sistema");
			System.exit(0);
		} else if( direccion.isEmpty()) {
			this.direccion = direccion;
		}else if(!direccion.contains(".txt")){
			JOptionPane.showMessageDialog(null, "La direcion es erronea pero se aigno \n" + this.direccionCopia);
		}
	}

	@SuppressWarnings("resource")
	public List<String> cargatTxt(boolean opcion) {
		if (opcion) {
			direccion.replace(".txt", "");
			direccion = direccion.concat("datosTienda.txt");
		}
		List<String> datosGuardaos = new ArrayList<String>();
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
		opcion = false;
		direccion = direccionCopia;
		return datosGuardaos;
	}

	public void guardarTxt(String entrada, boolean temporal, boolean opcion) {
		FileWriter archivoTxt = null;
		if (temporal == true) {
			direccion.replace(".txt", "");
			direccion = direccion.concat("datosTienda.txt");
		}
		try {
			archivoTxt = new FileWriter(direccion, opcion);
			archivoTxt.write(entrada);
			archivoTxt.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Se produjo un error al guardar la información");
		}
		opcion = false;
		temporal = false;
		direccion = direccionCopia;
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

	public void abrirarchivo() {
		try {
			File objetofile = new File(direccion);
			if (objetofile.exists()) {
				Desktop.getDesktop().open(objetofile);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error al abrir el documento txt");
		}
	}

	/****************************************************************************/

	/*
	 * public String getPelicula(int index) { String msj = null; if (index == 0)
	 * { JOptionPane.showMessageDialog(null, "Escoga una pelicula"); } else if
	 * (index == 1) { msj = "Buscando a Nemo"; } else if (index == 2) { msj =
	 * "Ciudad de Dios"; } else if (index == 3) { msj = "Hable con ella"; }
	 * return msj; }
	 */

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

}
