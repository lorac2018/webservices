package engsotware.projectws2.Models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Medico extends BaseModel  {

    private String nome;
    private String email;
    private String nrTelemovel;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "medico")
    private Set<Consulta> consultas=new HashSet<>();

    public Medico(String nome, String email, String nrTelemovel) {
        this.nome=nome;
        this.email=email;
        this.nrTelemovel=nrTelemovel;
    }

    // add consulta a um medico
    public void addConsutaToMedico(Consulta consulta){
            consultas.add(consulta);
            consulta.setMedico(this);
    }
}
