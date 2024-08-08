package org.example.model.teste;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.annotation.Mask;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Descricao {

    @Mask
    private int peso;
    private Float serial;
    private Deposito deposito;
    //private LocalDateTime entradaNoEstoque;

}
