package implementacion;

import java.util.ArrayList;
import java.util.Random;

import interfaz.AdministradorDeColas;

public class Metodos {

	public static AdministradorDeColas celu;

	public Metodos() {
		celu = new implementacionTDA();
	}

	public static ArrayList<String> obtenerTurnos() {

		ArrayList<String> turnos = new ArrayList<>();
		Random rand = new Random();
		int prioridad = -1;

		prioridad = celu.prioridad();

		if (prioridad != -1) {

			while (prioridad != -1) {

				String turno = "";
				int n;
				int ticket;
				int puesto;

				n = rand.nextInt(celu.cantPuestos());
				n += 1;

				ticket = celu.desacolar(n);
				puesto = celu.puestoDelElem(ticket);

				switch (prioridad) {

				case 45:
					turno = "PRP:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				case 60:
					turno = "ABO:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				case 90:
					turno = "CLI:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				}

				turnos.add(turno);
				celu.liberarPuesto(puesto);

				prioridad = celu.prioridad();

			}

		}

		return turnos;

	}

	public static ArrayList<String> Test() {

		Random rand = new Random();
		ArrayList<String> turnos = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {

			int n = rand.nextInt(3);
			n += 1;

			switch (n) {
			case 1:
				celu.acolar(45);
				break;

			case 2:
				celu.acolar(60);
				break;

			case 3:
				celu.acolar(90);
				break;
			}

		}

		int prioridad = -1;

		prioridad = celu.prioridad();

		if (prioridad != -1) {

			while (prioridad != -1) {

				String turno = "";
				int n;
				int ticket;
				int puesto;

				n = rand.nextInt(celu.cantPuestos());
				n += 1;

				ticket = celu.desacolar(n);
				puesto = celu.puestoDelElem(ticket);

				switch (prioridad) {

				case 45:
					turno = "PRP:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				case 60:
					turno = "ABO:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				case 90:
					turno = "CLI:" + ticket + " PUESTO NUMERO: " + puesto;
					break;

				}

				turnos.add(turno);
				celu.liberarPuesto(puesto);

				prioridad = celu.prioridad();

			}

		}
		return turnos;

	}

	
}
