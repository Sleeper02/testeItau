package Teste.testeItau.Docs;

import Teste.testeItau.Transacao.RequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Transações",
description = "Endpoint de criação de Transações")
public interface TransacaoControllerDoc {

    @Operation (summary = "Cria transação",
    description = "Recebe uma transação valida e adiciona em uma lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso!"),
            @ApiResponse(responseCode = "422", description = "Erro de validação capturado"),
            @ApiResponse(responseCode = "400", description = "Erro inesperado no servidor")
    })
    ResponseEntity adicionar(@RequestBody RequestDTO transacao);

    @Operation(summary = "Deleta as transações" ,
            description = "remove todas as transações adicionada a lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transações deletadas com sucesso!")
    })
    ResponseEntity deletar();

}
