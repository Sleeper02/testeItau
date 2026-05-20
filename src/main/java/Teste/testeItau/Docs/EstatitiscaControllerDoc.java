package Teste.testeItau.Docs;

import Teste.testeItau.Estatistica.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatisticas",
description = "Endpoint de estatisticas das transações")
public interface EstatitiscaControllerDoc {

    @Operation(summary = "Calcula as estatisticas",
            description = "Calcula soma, media, min e max das transações num periodo N de tempo, settado no properties")
    @ApiResponse(responseCode = "201", description = "Calculo feito com sucesso!")
    ResponseEntity<EstatisticaDTO> estatistica();
}
