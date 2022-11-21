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
public class Cliente extends Pessoa{
    private static final long serialVersionUID = 1603600876056379443L;

    private String tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicos = new ArrayList<>();

    public Cliente(Integer id, String nome, String email, String codNacional, String tipo) {
        super(id, nome, email, codNacional);
        this.tipo = tipo;
    }
}
