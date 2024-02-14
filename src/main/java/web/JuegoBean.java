package web;

import domain.Juego;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import servicio.JuegoService;

@Named("juegoBean")
@RequestScoped
public class JuegoBean {
        
        Logger log = LogManager.getRootLogger();

        @Inject
        private JuegoService juegoService;
        private List<Juego> juegos;
        private Juego juegoSeleccionado;

        public JuegoBean() {
        }

        @PostConstruct
        public void inicializar() {
                log.debug("HKJSADHFKJSDHFKJSHDFKSDHFJKH");
                juegos = juegoService.listarJuegos();
                juegoSeleccionado = new Juego();
        }
        
        public Juego getJuegoSeleccionado(){
                System.out.println("JUEGO SELECCIONADO" + juegoSeleccionado);
                return juegoSeleccionado;
        }

        public void setJuegoSeleccionado(Juego juegoSeleccionado){
                this.juegoSeleccionado = juegoSeleccionado;
                System.out.println("JUEGO: " + this.juegoSeleccionado);
        }
        
        public List<Juego> getJuegos() {
                System.out.println("JUEGO SELECCIONADO" + juegoSeleccionado);
                return juegos;
        }
        
        public void reiniciarJuegoSeleccionado(){
                juegoSeleccionado = new Juego();
        }
        
        public String detalles(Juego juego){
                juegoSeleccionado = juego;
                return "mostrarJuego";
        }
        
        public void agregarJuego(){
                juegoService.registrarJuego(juegoSeleccionado);
                juegos.add(juegoSeleccionado);
                juegoSeleccionado = null;
        }
        
        public void eliminarJuego(Juego juego){
                juegoService.eliminarJuego(juego);
                juegos.remove(juego);
        }
        
        public void editListener(RowEditEvent event){
                Juego juego = (Juego) event.getObject();
                juegoService.modificarJuego(juego);
        }

}
