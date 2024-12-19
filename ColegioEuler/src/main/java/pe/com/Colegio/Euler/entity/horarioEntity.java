
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
@Entity(name="horarioEntity")
@Table(name="horario")
public class horarioEntity implements Serializable{
    @Id
    @Column(name="codhorario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(name="diasdictado")
    private String dias;
    @Column(name="horalinicio")
    private String horainicio;
    @Column(name="horalfin")
    private String horafin;
    @Column(name="estado")
    private boolean estado= true;
}
