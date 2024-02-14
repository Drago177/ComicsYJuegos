package servicio;

import datos.JuegoDao;
import domain.Juego;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "servicio.JuegoServiceWS")
public class JuegoServiceImpl implements JuegoService {

        @Inject
        private JuegoDao juegoDao;
        
        @Override
        public List<Juego> listarJuegos() {
                return juegoDao.findAllJuegos();
        }

        @Override
        public Juego encontrarJuegoPorId(Juego juego) {
                return juegoDao.findByIdJuego(juego);
        }

        @Override
        public Juego encontrarJuegoPorNombre(Juego juego) {
                return juegoDao.findByNombre(juego);
        }

        @Override
        public void registrarJuego(Juego juego) {
                juegoDao.insertJuego(juego);
        }

        @Override
        public void modificarJuego(Juego juego) {
                juegoDao.updateJuego(juego);
        }

        @Override
        public void eliminarJuego(Juego juego) {
                juegoDao.deleteJuego(juego);
        }
        
}
