package model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = { "pets" })
@EqualsAndHashCode(exclude = { "pets" })

@Entity
public class Especie  implements Serializable {

    private static final long serialVersionUID = 3715169744786258362L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;

    @OneToMany(mappedBy = "especie")
    private List<Pet> pets = new ArrayList<>();

    public Especie(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
}
