package Teste.testeItau.Estatistica;

import Teste.testeItau.Docs.EstatitiscaControllerDoc;
import Teste.testeItau.Docs.TransacaoControllerDoc;
import Teste.testeItau.Transacao.TransacaoRepository;
import Teste.testeItau.Transacao.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatitiscaControllerDoc {

    @Autowired
    private EstatisticaService estatisticaService;

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @GetMapping()
    public ResponseEntity<EstatisticaDTO> estatistica() {

        //Log de requisicao (Lombok)
        log.info("Calculando estatiticas de transação nos " + estatisticaProperties.segundos() + " segundos");

        EstatisticaDTO dados = estatisticaService.dados();

        return ResponseEntity.ok(dados);

    }
}
