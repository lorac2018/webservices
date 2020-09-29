package engsotware.projectws2.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Consulta extends BaseModel {

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @ToString.Exclude
    private Medico medico;

    private LocalDateTime horario;
    private LocalDateTime fimExpectavel;

    public Consulta (LocalDateTime horario, Medico medico) {
        this.horario=horario;
        this.fimExpectavel=horario.plusMinutes(30);
        this.medico=medico;
    }
}