package servicio;

import domain.Juego;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;

@Path("/juegos")
@Stateless
public class JuegoServiceRS {
        @Inject
        private JuegoService juegoService;
        
        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Juego> listarJuegos(){
                return juegoService.listarJuegos();
        }
        
        @GET
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("{id}")
        public Juego encontrarJuegoPorId(@PathParam("id") int id){
                return juegoService.encontrarJuegoPorId(new Juego(id));
        }
        
        @POST
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Response agregarJuego(Juego juego){
                try{
                        juegoService.registrarJuego(juego);
                        return Response.ok().entity(juego).build();
                }
                catch(Exception e){
                        e.printStackTrace(System.out);
                        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
                }
        }
        
        @PUT
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Path("{id}")
        public Response modificarJuego(@PathParam("id") int id, Juego juegoModificado){
                try{
                        Juego juego = juegoService.encontrarJuegoPorId(new Juego(id));
                        if(juego != null){
                                juegoService.modificarJuego(juegoModificado);
                                return Response.ok().entity(juegoModificado).build();
                        }
                        else{
                                return Response.status(Status.NOT_FOUND).build();
                        }
                }catch(Exception e){
                        e.printStackTrace(System.out);
                        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
                }
        }
        
        @DELETE
        @Path("{id}")
        public Response eliminarJuegoPorId(@PathParam("id") int id){
                try{
                        juegoService.eliminarJuego(new Juego(id));
                        return Response.ok().build();
                }catch(Exception e){
                        e.printStackTrace(System.out);
                        return Response.status(404).build();
                }
        }
}
