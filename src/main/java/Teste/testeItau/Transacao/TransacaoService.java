package Teste.testeItau.Transacao;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTrasacao(RequestDTO transacao) {

        if(transacao.getValor() == null){
            throw new IllegalArgumentException("Erro: O valor da transação precisa ser preenchida");

        }if(transacao.getDataHora() == null){
            throw new IllegalArgumentException("Erro: A data da transação precisa ser preenchida");

        }if(transacao.getValor().compareTo(BigDecimal.ZERO) < 0 ){
            throw  new IllegalArgumentException("Erro: valor tem que ser maior ou igual a 0");

        }if(transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: Data de transação não pode ser no futuro");

        }
    }
}
