package datos;

import domain.Juego;
import java.util.List;

public interface JuegoDao {
    
    public List<Juego> findAllJuegos();
    
    public Juego findByIdJuego(Juego juego);
    
    public Juego findByNombre(Juego juego);
    
    public void insertJuego(Juego juego);
    
    public void updateJuego(Juego juego);
    
    public void deleteJuego(Juego juego);
    
}
