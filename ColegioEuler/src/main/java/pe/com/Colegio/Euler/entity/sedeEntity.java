
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
@Entity(name="sedeEntity")
@Table(name="sede")
public class sedeEntity implements Serializable{
    @Id
    @Column(name="codsede")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="nombre")
    private String nombre;
    @Column(name="direccion")
    private String direccion;
    @Column(name="estado")
    private boolean estado;
}
