
package pe.com.Colegio.Euler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="alumnoEntity")
@Table(name="alumno")
public class alumnoEntity implements Serializable{
    @Id
    @Column(name="codalumno")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="dni")
    private String dni;
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellidopaterno")
    private String apellidopaterno;
    @Column(name="apellidomaterno")
    private String apellidomaterno;
    
    @Column(name="fechanacimiento")
    private String fechanacimiento;
    
    @Column(name="telefono")
    private String telefono;
    @Column(name="estado")
    private boolean estado;
    
}