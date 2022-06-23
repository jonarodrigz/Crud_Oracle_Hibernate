
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.dao.PersonasDao;
import modelo.entities.Personas;


@Named(value = "personasController")
@ViewScoped
public class PersonasController implements Serializable{
    List<Personas> lstPersonas = new ArrayList<>();
    PersonasDao personaDao;
    Personas personaSelecionada;
   
    public PersonasController() {
       this.personaDao = new PersonasDao();
       this.personaSelecionada = new Personas();
    }

    public List<Personas> getLstPersonas() {
        this.lstPersonas = personaDao.getAll();
        return lstPersonas;
    }

    public void setLstPersonas(List<Personas> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public Personas getPersonaSelecionada() {
        return personaSelecionada;
    }

    public void setPersonaSelecionada(Personas personaSelecionada) {
        this.personaSelecionada = personaSelecionada;
    }
    
    public void limpiarPersona(){
        personaSelecionada = new Personas();
    }
    
    public void insertarPersona(){
        personaDao.insertar(personaSelecionada);
    }
    
    public void actualizarPersona(){
        personaDao.actualizar(personaSelecionada);
        limpiarPersona();
    }
    
    public void eliminarPersona(){
        personaDao.eliminar(personaSelecionada);
        limpiarPersona();
    }
    
    
    
}
