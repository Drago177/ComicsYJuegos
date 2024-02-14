package servicio;

import domain.Juego;
import java.util.List;
import javax.ejb.Local;

@Local
public interface JuegoService {

        public List<Juego> listarJuegos();

        public Juego encontrarJuegoPorId(Juego juego);

        public Juego encontrarJuegoPorNombre(Juego juego);

        public void registrarJuego(Juego juego);

        public void modificarJuego(Juego juego);

        public void eliminarJuego(Juego juego);
        
}
