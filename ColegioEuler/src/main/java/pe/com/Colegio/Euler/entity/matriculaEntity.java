
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
@Entity(name="matriculaEntity")
@Table(name="matricula")
public class matriculaEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="codmatricula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="fechamatricula")
    private String fecha;
    @Column(name="estado")
    private boolean estado;
    @ManyToOne
    @JoinColumn(name="codalumno", nullable=false)
    private alumnoEntity alumno;
    @ManyToOne
    @JoinColumn(name="codcurso", nullable=false)
    private cursoEntity curso;

}
