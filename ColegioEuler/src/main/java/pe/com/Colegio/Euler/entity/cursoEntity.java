
package pe.com.Colegio.Euler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="cursoEntity")
@Table(name="curso")
public class cursoEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="codcurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="modalidad")
    private String modalidad;
    @Column(name="fechainicio")
    private String fechainicio;
    @Column(name="fechafin")
    private String fechafin;
    @Column(name="estado")
    private boolean estado=true;
    
    @ManyToOne
    @JoinColumn(name="codaula", nullable=false)
    private aulaEntity aula;
    @ManyToOne
    @JoinColumn(name="codprofesor", nullable=false)
    private profesorEntity profesor;
    @ManyToOne
    @JoinColumn(name="codhorario", nullable=false)
    private horarioEntity horario;

    
    
}
