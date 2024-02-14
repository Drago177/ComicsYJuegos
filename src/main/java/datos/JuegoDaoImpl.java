package datos;

import domain.Juego;
import java.util.List;
import javax.persistence.*;

public class JuegoDaoImpl implements JuegoDao {
        @PersistenceContext(unitName="CyJPU")
        EntityManager em;

        @Override
        public List<Juego> findAllJuegos() {
                return em.createNamedQuery("Juego.findAll").getResultList();
        }

        @Override
        public Juego findByIdJuego(Juego juego) {
                return em.find(Juego.class, juego.getIdJuego());
        }

        @Override
        public Juego findByNombre(Juego juego) {
                return em.find(Juego.class, juego.getNombre());
        }

        @Override
        public void insertJuego(Juego juego) {
                em.persist(juego);
        }

        @Override
        public void updateJuego(Juego juego) {
                em.merge(juego);
        }

        @Override
        public void deleteJuego(Juego juego) {
                em.remove(em.merge(juego));
        }
}
