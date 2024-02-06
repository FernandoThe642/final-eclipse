package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.RecargaDAO;
import ec.edu.ups.ppw63.demo63.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {
    
    @Inject
    private RecargaDAO daoRecarga;

    public void guardarRecarga(Recarga recarga) {
        Recarga rec = daoRecarga.read(recarga.getId());
        if (rec != null) {
            daoRecarga.update(recarga);
        } else {
            daoRecarga.insert(recarga);
        }
    }
    
    public void actualizarRecarga(Recarga recarga) throws Exception {
        Recarga rec = daoRecarga.read(recarga.getId());
        if (rec != null) {
            daoRecarga.update(recarga);
        } else {
            throw new Exception("Recarga no existe");
        }
    }
    
    public Recarga leerRecarga(int id) throws Exception {
        Recarga recarga = daoRecarga.read(id);
        if (recarga == null) {
            throw new Exception("Recarga no encontrada");
        }
        return recarga;
    }
    
    public void borrarRecarga(int id) throws Exception {
        Recarga recarga = daoRecarga.read(id);
        if (recarga != null) {
            daoRecarga.remove(id);
        } else {
            throw new Exception("Recarga no existe para borrar");
        }
    }
    
    public List<Recarga> getTodasLasRecargas() {
        return daoRecarga.getAll();
    }
    

}
