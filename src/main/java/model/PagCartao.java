package model;

import lombok.*;
import model.enums.SituacaoPagamento;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
public class PagCartao extends Pagamento {

    private static final long serialVersionUID = -1143211403604898892L;

    private Integer parcelas;

    public PagCartao(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Integer parcelas) {
        super(id, valor, situacao, servico);
        this.parcelas = parcelas;
    }
}
