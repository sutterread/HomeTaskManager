package pa.microservicios.HomeTaskManager.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Asus Entidad a la que se le van a aplicar microservicios TABLA
 * actividades con id autogenerado
 */
@Entity
@Table(name = "actividades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividad;

    @Column(name = "titulo", nullable = false, unique = false, length = 50)
    private String titulo;
    @Column(name = "descripcion", nullable = false, unique = false, length = 50)
    private String descripcion;
    @Column(name = "fecha inicio", nullable = false, unique = false, length = 50)
    private String fechaInicio;
    @Column(name = "fecha Terminacion", nullable = false, unique = false, length = 50)
    private String fechaTerminacion;
    @Column(name = "id tutor", nullable = false, unique = true, length = 50)
    private int idTutor;
    @Column(name = "id hijo acargo", nullable = false, unique = true, length = 50)
    private int idHijoAcargo;
}
