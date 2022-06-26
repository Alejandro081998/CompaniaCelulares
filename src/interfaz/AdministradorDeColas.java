package interfaz;

import apis.DiccionarioSimpleTDA;

public interface AdministradorDeColas {

	void inicializar(int cantidad);

//siempre que el TDA esté inicializado 
	int acolar(int prioridad);

//siempre que el TDA esté inicializado 
	void acolar(int id, int prioridad);

//siempre que el TDA esté inicializado 
	int desacolar(int puesto);

//siempre que el TDA esté inicializado 
	int cantPuestos();

//siempre que el TDA esté inicializado 
	int primero();

//siempre que el TDA esté inicializado y cola no vacías
	int puestoDelElem(int idElemento);

//siempre que el TDA esté inicializado y cola no vacías
	DiccionarioSimpleTDA elementos();
//siempre que el TDA esté inicializado y cola no vacías
	
	boolean liberarPuesto(int puesto);

}
