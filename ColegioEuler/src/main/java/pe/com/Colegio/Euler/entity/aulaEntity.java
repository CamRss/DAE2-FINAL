
package pe.com.Colegio.Euler.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name="aulaEntity")
@Table(name="aula")
public class aulaEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="codaula")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="piso")
    private String piso;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="aforo")
    private int aforo;
    
    @Column(name="estado")
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name="codsede", nullable=false)
    private sedeEntity sede;
    

}
