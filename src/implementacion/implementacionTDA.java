package implementacion;

import apis.ColaPrioridadTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.PilaTDA;
import impl.ColaPrioridadAO;
import impl.ConjuntoTA;
import impl.DicSimpleA;
import impl.PilaTI;
import interfaz.AdministradorDeColas;

public class implementacionTDA implements AdministradorDeColas {

	private static boolean inicializado = false;
	private static ConjuntoTDA conjunto;
	private static ColaPrioridadTDA cola;
	private static DiccionarioSimpleTDA diccionario;
	private int puestos;

	@Override
	public void inicializar(int cantidad) {
		if (!inicializado) {
			conjunto = new ConjuntoTA();
			cola = new ColaPrioridadAO();
			diccionario = new DicSimpleA();
			conjunto.inicializarConjunto();
			cola.inicializarCola();
			diccionario.inicializarDiccionario();

			for (int i = 1; i <= cantidad; i++) {
				conjunto.agregar(i);
			}

			this.puestos = cantidad;

			this.inicializado = true;
		}

	}

	@Override
	public int acolar(int prioridad) {

		if (inicializado) {
			int ticket = 0;

			if (cola.colaVacia()) {
				ticket = 1;
				cola.acolarPrioridad(ticket, prioridad);
			}

			else {
				ticket = contarTickets();
				cola.acolarPrioridad(ticket, prioridad);
			}

			return ticket;
		} else
			return -1;
	}

	@Override
	public void acolar(int id, int prioridad) {
		if (inicializado) {
			cola.acolarPrioridad(id, prioridad);
		}

	}

	@Override
	public int desacolar(int puesto) {
		if (inicializado) {

			int ticket = 0;

			if (!cola.colaVacia()) {

				if (conjunto.pertenece(puesto)) {
					diccionario.agregar(cola.primero(), puesto);
					ticket = cola.primero();
					cola.desacolar();
					conjunto.sacar(puesto);
					return ticket;

				} else
					return -2;

			} else
				return -1;

		} else
			return 0;
	}

	@Override
	public int cantPuestos() {
		if (inicializado)
			return puestos;
		else
			return -1;
	}

	@Override
	public int primero() {
		if (inicializado && !cola.colaVacia())
			return cola.primero();
		else
			return -1;
	}

	@Override
	public int puestoDelElem(int idElemento) {
		if (inicializado) {
			return diccionario.recuperar(idElemento);
		} else
			return -1;
	}

	@Override
	public DiccionarioSimpleTDA elementos() {
		if (inicializado && !cola.colaVacia()) {
			return diccionario;
		}
		return null;
	}

	@Override
	public boolean liberarPuesto(int puesto) {
		if (inicializado && !conjunto.pertenece(puesto)) {
			conjunto.agregar(puesto);
			return true;
		} else
			return false;
	}

	@Override
	public int prioridad() {
		if (inicializado) {
			if (!cola.colaVacia())
				return cola.prioridad();
			else
				return -1;
		} else
			return -1;
	}
	
	@Override
	public boolean colaVacia() {
		if(cola.colaVacia())
			return true;
		else
			return false;
	}

	public static void pasarCola(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
		while (!c1.colaVacia()) {
			c2.acolarPrioridad(c1.primero(), c1.prioridad());
			c1.desacolar();
		}
	}

	public static void copiarCola(ColaPrioridadTDA c1, ColaPrioridadTDA c2) {
		ColaPrioridadTDA cAux = new ColaPrioridadAO();
		cAux.inicializarCola();
		pasarCola(c1, cAux);
		while (!cAux.colaVacia()) {
			c1.acolarPrioridad(cAux.primero(), cAux.prioridad());
			c2.acolarPrioridad(cAux.primero(), cAux.prioridad());
			cAux.desacolar();
		}

	}

	public static int contarTickets() {
		ColaPrioridadTDA cAux = new ColaPrioridadAO();
		cAux.inicializarCola();
		copiarCola(cola, cAux);
		int contador = 0;
		while (!cAux.colaVacia()) {
			cAux.desacolar();
			contador++;
		}
		return contador + 1;
	}


}
