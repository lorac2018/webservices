package engsotware.projectws2.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Clinica extends BaseModel {

    private String nome;
    private String email;
    private String nrTelemovel;
    private String morada;

    public Clinica (String nome, String email, String nrTelemovel, String morada) {
        this.nome=nome;
        this.email=email;
        this.nrTelemovel = nrTelemovel;
        this.morada=morada;
    }
}