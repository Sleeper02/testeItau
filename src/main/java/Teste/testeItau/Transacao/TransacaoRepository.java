package Teste.testeItau.Transacao;

import Teste.testeItau.Estatistica.EstatisticaProperties;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class TransacaoRepository {

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    private List<RequestDTO> listaTransacao = new ArrayList<>();

    public void salvarDados(RequestDTO dados){
        listaTransacao.add(dados);
    }

    public List<RequestDTO> getListaTransacao(){
        return listaTransacao.stream()
                .filter(dto ->
                        Duration.between(dto.getDataHora(), OffsetDateTime.now())
                        .compareTo(Duration.ofSeconds(estatisticaProperties.segundos())) <= 0)
                .collect(Collectors.toList());

    }


    public void deletarDados(){
        listaTransacao.clear();
    }
}
