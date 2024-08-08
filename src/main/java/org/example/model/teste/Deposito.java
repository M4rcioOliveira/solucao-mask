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
public class Deposito {

    @Mask('x')
    private Integer id;
    private String endereco;

}
