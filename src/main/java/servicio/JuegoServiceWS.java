package servicio;

import domain.Juego;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface JuegoServiceWS {
        
        @WebMethod
        public List<Juego> listarJuegos();
        
}
