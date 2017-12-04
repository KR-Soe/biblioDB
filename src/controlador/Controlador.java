package controlador;

import java.util.ArrayList;
import modelo.Libro;
import modelo.LibroDAO;

public class Controlador {
    
    public boolean agregar(Libro a){
       
        LibroDAO ad = new LibroDAO();
        if(ad.insert(a)>0){
            return true;
        }
        return false;
    }
    
    public boolean modificar(Libro a){
       
        LibroDAO ad = new LibroDAO();
        if(ad.update(a)>0){
            return true;
        }
        return false;
    }
    public boolean eliminar(Integer id){
        LibroDAO ad = new LibroDAO();
        if (ad.delete(id)>0){
            return true;
        }
        return false;
    }
    public Libro leer(Integer id){
        LibroDAO ad = new LibroDAO();
        return ad.read(id);
    }
    
    public ArrayList<Libro> consultarTodo(){
        LibroDAO ad = new LibroDAO();
        
        ArrayList<Libro> lista = ad.readAll();
        return lista;
    }
}
