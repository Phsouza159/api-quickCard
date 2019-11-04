package com.quickcard.config;

public class  RoutesController {

    public final static String AUTHENTICATE = "/authenticate";

    public final static String CARTAO_MEMORIA_PATH = "/cartaoMemoria";
    public final static String CARTAO_MEMORIA_PATH_ID = "/cartaoMemoria/{id}";
    public final static String CARTAO_MEMORIA_PATH_ID_ESTUDANTE_ID_CARTAO = "/cartaoMemoria/{idEstudante}/{idCartao}";

    public final static String BLOCO_CARTAO_MEMORIA_PATH_ID_BLOCO = "/blocoCartaoMemoria/{idEstudante}/{idBloco}";
    public final static String BLOCO_CARTAO_MEMORIA_PATH_ID_ESTUDANTE = "/blocoCartaoMemoria/{idEstudante}";

}
