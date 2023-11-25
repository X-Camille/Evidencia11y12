package org.example.evidencia12;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUITrabajador implements ActionListener {

	private Trabajador trabajador;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoRut;
	private JTextField campoIsapre;
	private JTextField campoAfp;

	private JButton bAgregar;
	private JButton bEditar;


	public GUITrabajador(Trabajador trabajador){
		this.trabajador = trabajador;
	}

	public void mostrarInterfaz() {
		JFrame frame = crearFrame();
		JPanel panelPrincipal = crearPanelPrincipal();

		JLabel labelTitulo = crearLabelTitulo();
		panelPrincipal.add(labelTitulo);
		configurarDimensionesCampos();
		crearPanelesCampos(panelPrincipal);
		inicializarCampos();
		deshabilitarCampos();
		establecerBotones(panelPrincipal);

		frame.add(panelPrincipal);
		frame.setVisible(true);
	}

	private JFrame crearFrame() {
		JFrame frame = new JFrame("Trabajador");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		return frame;
	}

	private void crearPanelesCampos(JPanel panelPrincipal){
		JPanel panelNombre = crearPanelCampo("Nombre:", campoNombre);
		panelPrincipal.add(panelNombre);
		JPanel panelApellido = crearPanelCampo("Apellido:", campoApellido);
		panelPrincipal.add(panelApellido);
		JPanel panelRut = crearPanelCampo("RUT:", campoRut);
		panelPrincipal.add(panelRut);
		JPanel panelIsapre = crearPanelCampo("Isapre:", campoIsapre);
		panelPrincipal.add(panelIsapre);
		JPanel panelAfp = crearPanelCampo("AFP:", campoAfp);
		panelPrincipal.add(panelAfp);
	}


	private void configurarDimensionesCampos(){
		campoNombre = new JTextField(20);
		campoApellido = new JTextField(20);
		campoRut = new JTextField(20);
		campoIsapre = new JTextField(20);
		campoAfp = new JTextField(20);
	}

	private JPanel crearPanelPrincipal() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		return panelPrincipal;
	}

	private JLabel crearLabelTitulo() {
		JLabel labelTitulo = new JLabel("INFORMACIÓN DEL TRABAJADOR");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 14));
		labelTitulo.setBorder(new EmptyBorder(20, 0, 10, 0));
		labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		return labelTitulo;
	}

	private JPanel crearPanelCampo(String labelText, JTextField textField) {
		JPanel panelCampo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labelCampo = new JLabel(labelText);
		panelCampo.add(labelCampo);
		panelCampo.add(textField);
		return panelCampo;
	}

	private void establecerBotones(JPanel panelPrincipal){
		JButton agregarButton = crearBoton("Agregar", new Color(0, 150, 0), e -> guardarDatos());
		JButton editarButton = crearBoton("Editar", new Color(255, 165, 0), e -> habilitarCampos());
		JPanel panelBotones = crearPanelBotones(agregarButton, editarButton);
		panelPrincipal.add(panelBotones);
	}

	private JButton crearBoton(String text, Color bgColor, ActionListener listener) {
		JButton button = new JButton(text);
		button.setBackground(bgColor);
		button.setForeground(Color.WHITE);
		button.setPreferredSize(new Dimension(150, 40));
		button.addActionListener(listener);
		return button;
	}

	private JPanel crearPanelBotones(JButton agregarButton, JButton editarButton) {
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBotones.add(agregarButton);
		panelBotones.add(editarButton);
		return panelBotones;
	}

	private void inicializarCampos() {
		campoNombre.setText(trabajador.getNombre());
		campoApellido.setText(trabajador.getApellido());
		campoRut.setText(trabajador.getRut());
		campoIsapre.setText(trabajador.getIsapre());
		campoAfp.setText(trabajador.getAfp());
	}

	private void deshabilitarCampos() {
		campoNombre.setEnabled(false);
		campoApellido.setEnabled(false);
		campoRut.setEnabled(false);
		campoIsapre.setEnabled(false);
		campoAfp.setEnabled(false);
	}

	private void habilitarCampos() {
		campoNombre.setEnabled(true);
		campoApellido.setEnabled(true);
		campoRut.setEnabled(true);
		campoIsapre.setEnabled(true);
		campoAfp.setEnabled(true);
	}

	private void guardarDatos() {
		trabajador.setNombre(campoNombre.getText());
		trabajador.setApellido(campoApellido.getText());
		trabajador.setRut(campoRut.getText());
		trabajador.setIsapre(campoIsapre.getText());
		trabajador.setAfp(campoAfp.getText());

		deshabilitarCampos();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bAgregar) {
			guardarDatos();
		} else if (e.getSource() == bEditar) {
			habilitarCampos();
		}
	}
}