package interfaz;

import apis.DiccionarioSimpleTDA;

public interface AdministradorDeColas {

	void inicializar(int cantidad);

//siempre que el TDA est� inicializado 
	int acolar(int prioridad);

//siempre que el TDA est� inicializado 
	void acolar(int id, int prioridad);

//siempre que el TDA est� inicializado 
	int desacolar(int puesto);

//siempre que el TDA est� inicializado 
	int cantPuestos();

//siempre que el TDA est� inicializado 
	int primero();

//siempre que el TDA est� inicializado y cola no vac�as
	int puestoDelElem(int idElemento);

//siempre que el TDA est� inicializado y cola no vac�as
	DiccionarioSimpleTDA elementos();
//siempre que el TDA est� inicializado y cola no vac�as
	
	boolean liberarPuesto(int puesto);

}
