package model;

import lombok.*;
import model.enums.SituacaoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
public class PagDinheiro extends Pagamento{

    private static final long serialVersionUID = -8569449730281946675L;

    private Date dataVencimento;
    private Double desconto;

    public PagDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataVencimento,
                       Double desconto) {
        super(id, valor, situacao, servico);
        this.dataVencimento = dataVencimento;
        this.desconto = desconto;
    }
}
