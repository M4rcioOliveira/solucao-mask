package org.example.model.teste;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.annotation.Mask;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {


    private String nome;
    @Mask('-')
    private double valor;
    @Mask()
    private Integer quantidade;
    private Descricao descricao;

}
