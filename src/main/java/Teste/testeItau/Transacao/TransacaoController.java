package Teste.testeItau.Transacao;

import Teste.testeItau.Docs.TransacaoControllerDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController implements TransacaoControllerDoc {

    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping()
    public ResponseEntity adicionar(@RequestBody RequestDTO transacao){

        try{
            log.info("Criando uma transação: ");
            transacaoService.validarTrasacao(transacao);
            transacaoRepository.salvarDados(transacao);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (IllegalArgumentException e){ //422
            log.error("Erro em uma ou mais validações: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

    }

    @DeleteMapping()
    public ResponseEntity deletar(){
        log.info("Deletando todos os dados");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleInvalidJson(HttpMessageNotReadableException e){
        log.error("Erro no servidor: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
