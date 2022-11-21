package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import model.enums.SituacaoPagamento;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 4098535502352253812L;

    @Id
    private Integer id;
    private Double valor;
    private Integer situacao;

    @JsonIgnore
    @MapsId
    @OneToOne
    @JoinColumn(name = "id_servico")
    private Servico servico;

    public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
        this.id = id;
        this.valor = valor;
        this.situacao = situacao.getCod();
        this.servico = servico;
    }
}
