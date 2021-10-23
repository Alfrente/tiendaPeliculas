package grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.LogicaTienda;

public class Interfaz extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LogicaTienda logicaTienda = new LogicaTienda();
	private JPanel contentPane;
	private JTextField entradaCantidad;
	private int incremento = 1;
	private String tienda;
	private final JComboBox<String> comboBoxPelicula = new JComboBox<String>();
	private String cantidadDatos = "";
	private int catidaDatos = 0;
	private boolean abrirInterface;
	private int salir = 0;
	private int salirPrograma = 0;
	private StringBuffer guararPeliculas = new StringBuffer();
	private TextArea textAreaPeliDispo = new TextArea(); 

	// private String[] peliculas = new String[20];

	private String getDatosTienda() {
		StringBuffer datos = new StringBuffer();
		List<String> lista = logicaTienda.cargatTxt(true);
		if (!(lista.isEmpty())) {
			for (String s : lista) {
				datos = datos.append(s);
			}
		}
		return datos.toString();
	}
	
	private String getDatosGuardaos() {
		StringBuffer datos = new StringBuffer();
		List<String> lista = logicaTienda.cargatTxt(false);
		if (!(lista.isEmpty())) {
			for (String s : lista) {
				datos = datos.append(s);
			}
		}
		return datos.toString();
	}


	private void nombreTienda(String tienda) {
		if (tienda == null) {
			JOptionPane.showMessageDialog(null, "Canselo el ingreso del nombre de la tienda el programa se cerro");
			System.exit(0);
		}else if( tienda.isEmpty()) {
			this.tienda = "TIENDA DE PELICULAS";
			JOptionPane.showMessageDialog(null, "Se le asigno el nombre de " + this.tienda);
		} else {
			this.tienda = tienda;
		}
	}

	public Interfaz() {

		nombreTienda(JOptionPane.showInputDialog("Ingrese el nombre de la tienda o dele en aceptar para que el programa lo haga"));

		logicaTienda.ubicacionArchivo(JOptionPane.showInputDialog("Ingrese la ubicación donde desea guardar la información\n                           EJ: C:\\Txt\\parcial.txt \no dele en aceptar para guardarlo automaticamente"));
		comboBoxPelicula.addItem("");

		do {
			cantidadDatos = JOptionPane
					.showInputDialog("Ingrese el numero de la cantidad de peliculas que va a ingresar");

			if (cantidadDatos == null) {
				++salirPrograma;
				cantidadDatos = "";
				if (salirPrograma == 2) {
					System.exit(0);
				}
				JOptionPane.showMessageDialog(null,
						"Dele de nuevo en cancelar para salir");

			} else if (cantidadDatos.isEmpty()) {
				JOptionPane.showMessageDialog(null,
						"Error falta la cantidad de pelicula que va a añadiir");
			} else {
				catidaDatos = logicaTienda.setCantidaPelicula(cantidadDatos);
				catidaDatos = catidaDatos - 1;
				int l = -1;
				if (catidaDatos >= 1) {
					for (int i = 0; i < catidaDatos; i++) {
						do {
							String pelicula = logicaTienda.setPelicula();
							guararPeliculas.append(pelicula + ",\t");
							
							if (pelicula != null && !(pelicula.isEmpty())) {
								comboBoxPelicula.addItem(pelicula);
								l = 0;
							} else if (pelicula == null) {
								++salir;
								if (salir == 2) {
									JOptionPane
											.showMessageDialog(null,
													"El programa se cerro por que le dio en cancelar 2 veces");
									System.exit(0);
								}
							} else if (pelicula.isEmpty()) {
								l = -1;
								JOptionPane
										.showMessageDialog(null,
												"Error el nombre de la pelicula esta vacio");

							}
						} while (l != 0);
					}
				}
			}
			abrirInterface = logicaTienda.validarNumero(cantidadDatos);

			if (abrirInterface == true && !cantidadDatos.isEmpty()) {
				abrirInterface = true;
			} else if (abrirInterface == false && cantidadDatos.isEmpty()) {
				abrirInterface = false;
			}

		} while (abrirInterface != true);
		
		logicaTienda.guardarTxt(" Peliculas disponibles: " + guararPeliculas.toString(),true, false);
		
		String datosTemporal =  getDatosTienda();
		textAreaPeliDispo.setText(datosTemporal);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 653, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(65, 105, 225));
		editorPane.setEditable(false);
		editorPane.setBounds(-26, 549, 62, 61);
		contentPane.add(editorPane);

		
		textAreaPeliDispo.setBackground(new Color(240, 248, 255));
		textAreaPeliDispo.setEditable(false);
		textAreaPeliDispo.setBounds(43, 168, 560, 133);
		contentPane.add(textAreaPeliDispo);

		final TextArea textArea = new TextArea();
		textArea.setBackground(new Color(240, 248, 255));
		textArea.setEditable(false);
		textArea.setBounds(61, 357, 526, 133);
		contentPane.add(textArea);

		JButton btnProbarSalida = new JButton("probar salida");
		btnProbarSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// textAreaPeliDispo

			}
		});
		btnProbarSalida.setBounds(81, 503, 89, 23);
		contentPane.add(btnProbarSalida);

		entradaCantidad = new JTextField();
		entradaCantidad.setBackground(new Color(255, 250, 250));
		entradaCantidad.setBounds(360, 100, 113, 20);
		contentPane.add(entradaCantidad);
		entradaCantidad.setColumns(10);

		JLabel lblInformacin_1 = new JLabel("INFORMACI\u00D3N");
		lblInformacin_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin_1.setForeground(new Color(65, 105, 225));
		lblInformacin_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformacin_1.setBounds(244, 313, 124, 22);
		contentPane.add(lblInformacin_1);

		JEditorPane linea5 = new JEditorPane();
		linea5.setEditable(false);
		linea5.setBackground(Color.LIGHT_GRAY);
		linea5.setBounds(257, 335, 100, 1);
		contentPane.add(linea5);

		JLabel sinemaUsb = new JLabel(tienda);
		sinemaUsb.setForeground(new Color(65, 105, 225));
		sinemaUsb.setFont(new Font("Tahoma", Font.BOLD, 19));
		sinemaUsb.setHorizontalAlignment(SwingConstants.CENTER);
		sinemaUsb.setBounds(21, 31, 605, 32);
		contentPane.add(sinemaUsb);

		JEditorPane linea2 = new JEditorPane();
		linea2.setEditable(false);
		linea2.setBackground(new Color(192, 192, 192));
		linea2.setBounds(275, 66, 100, 1);
		contentPane.add(linea2);

		JLabel lblPrecio = new JLabel("PRECIO");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setForeground(new Color(65, 105, 225));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecio.setBounds(438, 145, 90, 20);
		contentPane.add(lblPrecio);

		JLabel lblClasificacin = new JLabel("CLASIFICACI\u00D3N");
		lblClasificacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacin.setForeground(new Color(65, 105, 225));
		lblClasificacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasificacin.setBounds(61, 145, 124, 20);
		contentPane.add(lblClasificacin);

		JLabel lblInformacin = new JLabel("INFORMACI\u00D3N");
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setForeground(new Color(65, 105, 225));
		lblInformacin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInformacin.setBounds(244, 143, 124, 22);
		contentPane.add(lblInformacin);

		JEditorPane linea1 = new JEditorPane();
		linea1.setEditable(false);
		linea1.setBackground(new Color(192, 192, 192));
		linea1.setBounds(43, 133, 560, 1);
		contentPane.add(linea1);

		// final JComboBox<String> comboBoxPelicula = new JComboBox();
		comboBoxPelicula.setBounds(61, 100, 124, 20);
		// comboBoxPelicula.addItem("");
		// comboBoxPelicula.addItem("Buscando a Nemo");
		// comboBoxPelicula.addItem("Ciudad de Dios");
		// comboBoxPelicula.addItem("Hable con ella");
		contentPane.add(comboBoxPelicula);

		final JComboBox<String> comboBoxHorario = new JComboBox<String>();
		comboBoxHorario.setBounds(209, 100, 124, 20);
		comboBoxHorario.addItem("");
		comboBoxHorario.addItem("Mañana");
		comboBoxHorario.addItem("Tarde");
		comboBoxHorario.addItem("Noche");
		contentPane.add(comboBoxHorario);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean guadarFecha = true;
				if(guadarFecha){
					guadarFecha = false;
					DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MMMM/dd hh:mm:ss") ;
					String fecha = "\n\nFecha: " + formato.format(LocalDateTime.now()) + "\n";
					logicaTienda.guardarTxt(fecha,false, true);
				}
				
				boolean valido = logicaTienda.validarNumero(entradaCantidad
						.getText());
				if (valido) {
					int indexPelicula = comboBoxPelicula.getSelectedIndex();

					// String pelicula =
					// logicaTienda.getPelicula(indexPelicula);

					String nombrePeli = logicaTienda
							.getPelicula2(indexPelicula);
					int precio = logicaTienda
							.calcularAsignarPrecio(nombrePeli);
					int precioTotal = precio
							* Integer.parseInt(entradaCantidad.getText());
					int indexHorario = comboBoxHorario.getSelectedIndex();
					String horario = logicaTienda.getHorario(indexHorario);

					if ((indexPelicula >= 1 && indexPelicula <= 4)
							&& (indexHorario >= 1 && indexHorario <= 4)) {
						logicaTienda.guardarTxt("#" + incremento
								+ ":) Pelicula: " + nombrePeli + ", Horario: "
								+ horario.toString()
								+ ", Cantidad de boletos: "
								+ entradaCantidad.getText()
								+ ", precio unidad: " + precio
								+ ", precio total: " + precioTotal + "\n", false, true);
						JOptionPane.showMessageDialog(null,
								"Información guardada ");
						incremento++;
					}
					textArea.setText(getDatosGuardaos());
				} else {
					JOptionPane.showMessageDialog(null,
							"Cantidad invalida intente nuevamente");
				}

			}
		});
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBackground(new Color(135, 206, 250));
		btnAgregar.setBounds(490, 99, 90, 20);
		contentPane.add(btnAgregar);

		JLabel cantidad = new JLabel("CANTIDAD");
		cantidad.setHorizontalAlignment(SwingConstants.CENTER);
		cantidad.setForeground(new Color(65, 105, 225));
		cantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		cantidad.setBounds(371, 80, 81, 20);
		contentPane.add(cantidad);

		JEditorPane fondoBlanco_1 = new JEditorPane();
		fondoBlanco_1.setEditable(false);
		fondoBlanco_1.setBackground(new Color(135, 206, 250));
		fondoBlanco_1.setBounds(356, 99, 120, 22);
		contentPane.add(fondoBlanco_1);

		JLabel pelicula = new JLabel("PEL\u00CDCULA");
		pelicula.setHorizontalAlignment(SwingConstants.CENTER);
		pelicula.setForeground(new Color(65, 105, 225));
		pelicula.setFont(new Font("Tahoma", Font.BOLD, 13));
		pelicula.setBounds(81, 80, 81, 20);
		contentPane.add(pelicula);

		JLabel horario = new JLabel("HORARIO");
		horario.setHorizontalAlignment(SwingConstants.CENTER);
		horario.setForeground(new Color(65, 105, 225));
		horario.setFont(new Font("Tahoma", Font.BOLD, 13));
		horario.setBounds(230, 80, 81, 20);
		contentPane.add(horario);

		JButton btnConfirmar = new JButton("SALIR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logicaTienda.abrirarchivo();
				System.exit(0);
			}
		});
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(257, 503, 113, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.setBackground(new Color(135, 206, 250));

		JEditorPane linea4 = new JEditorPane();
		linea4.setEditable(false);
		linea4.setBackground(Color.LIGHT_GRAY);
		linea4.setBounds(49, 307, 560, 1);
		contentPane.add(linea4);

		JEditorPane linea3 = new JEditorPane();
		linea3.setEditable(false);
		linea3.setBackground(Color.LIGHT_GRAY);
		linea3.setBounds(257, 168, 100, 1);
		contentPane.add(linea3);

		JEditorPane fondoGrisOscuro = new JEditorPane();
		fondoGrisOscuro.setEditable(false);
		fondoGrisOscuro.setBackground(new Color(100, 149, 237));
		fondoGrisOscuro.setBounds(57, 352, 530, 143);
		contentPane.add(fondoGrisOscuro);

		JEditorPane fondoGris = new JEditorPane();
		fondoGris.setBackground(SystemColor.controlHighlight);
		fondoGris.setEditable(false);
		fondoGris.setBounds(49, 346, 554, 191);
		contentPane.add(fondoGris);

		JEditorPane fondoBlanco = new JEditorPane();
		fondoBlanco.setBounds(21, 21, 605, 546);
		contentPane.add(fondoBlanco);
		fondoBlanco.setEditable(false);
		fondoBlanco.setBackground(new Color(255, 255, 255));

		JEditorPane fondoAzul = new JEditorPane();
		fondoAzul.setEditable(false);
		fondoAzul.setBackground(new Color(135, 206, 250));
		fondoAzul.setBounds(-18, -37, 693, 639);
		contentPane.add(fondoAzul);
	}
}
