package org.example;

import org.example.model.log.Log;
import org.example.model.teste.Deposito;
import org.example.model.teste.Descricao;
import org.example.model.teste.Produto;
import org.example.util.CustomLogger;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        CustomLogger logger = new CustomLogger();

        Produto produto = new Produto("PRODUTO TESTE", 12, 3, new Descricao(453, 121F, new Deposito(12,"luziania")));

        logger.log("Imprimindo teste", produto);

        Log log = new Log();

        System.out.println("Hello world!");
    }
}