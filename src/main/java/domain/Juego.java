package domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j"),
        @NamedQuery(name = "Juego.findByIdJuego", query = "SELECT j FROM Juego j WHERE j.idJuego = :idJuego"),
        @NamedQuery(name = "Juego.findByNombre", query = "SELECT j FROM Juego j WHERE j.nombre = :nombre")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Juego implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id_juego")
        private Integer idJuego;
        @Size(max = 45)
        private String nombre;
        @Size(max = 45)
        private String descripcion;
        @Size(max = 45)
        private String imagen;

        public Juego() {
        }

        public Juego(String nombre, String descripcion, String imagen) {
                this.nombre = nombre;
                this.descripcion = descripcion;
                this.imagen = imagen;
        }

        public Juego(Integer idJuego) {
                this.idJuego = idJuego;
        }

        public Integer getIdJuego() {
                return idJuego;
        }

        public void setIdJuego(Integer idJuego) {
                this.idJuego = idJuego;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public String getImagen() {
                return imagen;
        }

        public void setImagen(String imagen) {
                this.imagen = imagen;
        }

        @Override
        public int hashCode() {
                int hash = 0;
                hash += (idJuego != null ? idJuego.hashCode() : 0);
                return hash;
        }

        @Override
        public boolean equals(Object object) {
                // TODO: Warning - this method won't work in the case the id fields are not set
                if (!(object instanceof Juego)) {
                        return false;
                }
                Juego other = (Juego) object;
                if ((this.idJuego == null && other.idJuego != null) || (this.idJuego != null && !this.idJuego.equals(other.idJuego))) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "Juego{" + "idJuego=" + idJuego + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + '}';
        }
        
}
