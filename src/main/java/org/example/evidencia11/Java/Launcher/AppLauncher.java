package org.example.evidencia11.Java.Launcher;

import org.example.evidencia12.GUITrabajador;
import org.example.evidencia12.Trabajador;

public class AppLauncher {
	public static void main(String[] args) {
		Trabajador trabajador = new Trabajador("Juan", "Perez", "213472712", "Banmedica", "AFP Provida");
		GUITrabajador ventana = new GUITrabajador(trabajador);
		ventana.mostrarInterfaz();
	}
}