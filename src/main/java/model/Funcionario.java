package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = { "servicos" })
@EqualsAndHashCode(callSuper = true, exclude = { "servicos" })

@Entity
public class Funcionario extends Pessoa{

    private static final long serialVersionUID = 5104413135978670994L;

    private String funcao;

    @JsonIgnore
    @OneToMany(mappedBy = "funcionario")
    private List<Servico> servicos = new ArrayList<>();

    public Funcionario(Integer id, String nome, String email, String codNacional, String funcao) {
        super(id, nome, email, codNacional);
        this.funcao = funcao;
    }
}
