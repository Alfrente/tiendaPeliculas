package grafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private void nombreTienda(String tienda){
		if(tienda.isEmpty()){
			this.tienda = "TIENDA DE PELICULAS";
		}else{
			this.tienda = tienda;
		}	
	}
	
	@SuppressWarnings("rawtypes")
	public Interfaz() {

		nombreTienda(JOptionPane.showInputDialog("Ingrese el nombre de la tienda"));
		
		logicaTienda.ubicacionArchivo(JOptionPane.showInputDialog("Ingrese la ubicación don desea guardar la información\nEJ: C:\\Txt\\parcial.txt \no dele en aceptar para guardarlo en el disco C"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblH_2 = new JLabel("1 h 30 min");
		lblH_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblH_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblH_2.setBounds(362, 240, 90, 14);
		contentPane.add(lblH_2);
		
		JLabel lblBuscandoANemo_1_1_1_1_1 = new JLabel("1 h 54 min");
		lblBuscandoANemo_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscandoANemo_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscandoANemo_1_1_1_1_1.setBounds(362, 265, 90, 14);
		contentPane.add(lblBuscandoANemo_1_1_1_1_1);
		
		JLabel lblH_1_1 = new JLabel("2 h 00 min");
		lblH_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblH_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblH_1_1.setBounds(372, 215, 69, 14);
		contentPane.add(lblH_1_1);
		
		JLabel lblBuscandoANemo = new JLabel("Buscando a Nemo");
		lblBuscandoANemo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscandoANemo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscandoANemo.setBounds(137, 216, 114, 14);
		contentPane.add(lblBuscandoANemo);
		
		JLabel lblCiudadDeDios = new JLabel("Ciudad de Dios");
		lblCiudadDeDios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCiudadDeDios.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiudadDeDios.setBounds(137, 241, 114, 14);
		contentPane.add(lblCiudadDeDios);
		
		final TextArea textArea = new TextArea();
		textArea.setBounds(61, 357, 526, 133);
		contentPane.add(textArea);
		
		JLabel lblBuscandoANemo_1_1 = new JLabel("Hable con ella");
		lblBuscandoANemo_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscandoANemo_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscandoANemo_1_1.setBounds(137, 266, 114, 14);
		contentPane.add(lblBuscandoANemo_1_1);

		entradaCantidad = new JTextField();
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
		lblPrecio.setBounds(362, 184, 90, 20);
		contentPane.add(lblPrecio);

		JLabel lblClasificacin = new JLabel("CLASIFICACI\u00D3N");
		lblClasificacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacin.setForeground(new Color(65, 105, 225));
		lblClasificacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClasificacin.setBounds(127, 184, 124, 20);
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
		
		@SuppressWarnings("unchecked")
		final JComboBox<String> comboBoxPelicula = new JComboBox();
		comboBoxPelicula.setBounds(61, 100, 124, 20);
		comboBoxPelicula.addItem("");
		comboBoxPelicula.addItem("Buscando a Nemo");
		comboBoxPelicula.addItem("Ciudad de Dios");
		comboBoxPelicula.addItem("Hable con ella");
		contentPane.add(comboBoxPelicula);

		@SuppressWarnings("unchecked")
		final JComboBox<String> comboBoxHorario = new JComboBox();
		comboBoxHorario.setBounds(209, 100, 124, 20);
		comboBoxHorario.addItem("");
		comboBoxHorario.addItem("Mañana");
		comboBoxHorario.addItem("Tarde");
		comboBoxHorario.addItem("Noche");
		contentPane.add(comboBoxHorario);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean valido = logicaTienda.validarNumero(entradaCantidad.getText());
				if (valido) {
					int indexPelicula = comboBoxPelicula.getSelectedIndex();
					String pelicula = logicaTienda.getPelicula(indexPelicula);
					int indexHorario = comboBoxHorario.getSelectedIndex();	
					String horario = logicaTienda.getHorario(indexHorario);
					if((indexPelicula>=1 && indexPelicula<=4) && (indexHorario>=1 && indexHorario<=4)){
						logicaTienda.guardarTxt("#" + incremento + ":) Pelicula: " + pelicula + ", Horario: " + horario.toString() + ", Cantidad de boletos: " + entradaCantidad.getText() + "\n");
						JOptionPane.showMessageDialog(null, "Guardando información");
						incremento++;
					}
					StringBuffer datos = new StringBuffer();
					List<String> lista = logicaTienda.cargatTxt();
					if(!(lista.isEmpty())){
						for(String s: lista){
							datos=datos.append(s);
						}
					}
					textArea.setText(datos.toString());
				}else{
					JOptionPane.showMessageDialog(null, "Cantidad inavlida intente nuevamente");
				}
			}
		});
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAgregar.setBackground(new Color(123, 104, 238));
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
		fondoBlanco_1.setBackground(new Color(65, 105, 225));
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
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(268, 503, 113, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.setBackground(new Color(123, 104, 238));

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
		fondoGrisOscuro.setBackground(SystemColor.controlShadow);
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

		JEditorPane fondoMorado = new JEditorPane();
		fondoMorado.setEditable(false);
		fondoMorado.setBackground(new Color(255, 255, 255));
		fondoMorado.setBounds(-18, -37, 693, 639);
		contentPane.add(fondoMorado);
	}
}
