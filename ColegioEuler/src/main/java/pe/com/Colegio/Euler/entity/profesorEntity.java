
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
@Entity(name="profesorEntity")
@Table(name="profesor")
public class profesorEntity implements Serializable{
    @Id
    @Column(name="codprofesor")
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
    
    @Column(name="correoelectronico")
    private String correo;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="especialidad")
    private String especialidad;
    @Column(name="estado")
    private boolean estado;
    
}
