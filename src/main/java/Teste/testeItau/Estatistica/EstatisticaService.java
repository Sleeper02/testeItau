package Teste.testeItau.Estatistica;

import Teste.testeItau.Transacao.RequestDTO;
import Teste.testeItau.Transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;

@Service
public class EstatisticaService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public EstatisticaDTO dados(){
        List<RequestDTO> lista = transacaoRepository.getListaTransacao();

        if(lista.isEmpty()){
            return new EstatisticaDTO(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO) ;
        }

        int count = lista.size();

//        DoubleSummaryStatistics dados = lista.stream()
//                .collect(Collectors.summarizingDouble(dto-> dto.getValor().doubleValue()));

//        double avg = dados.getAverage();
//        double max = dados.getMax();
//        double min = dados.getMin();
//        double sum = dados.getSum();
//
//        if(max == Double.NEGATIVE_INFINITY) max = 0.0;
//        if(min == Double.POSITIVE_INFINITY) min = 0.0;
// vamos focar na precisão

        BigDecimal sum = lista.stream()
                .map(RequestDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avg = sum.divide(BigDecimal.valueOf(count), 3, RoundingMode.HALF_UP);

        BigDecimal max = lista.stream()
                .map(RequestDTO::getValor)
                .max(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);

        BigDecimal min = lista.stream()
                .map(RequestDTO::getValor)
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);



        return new EstatisticaDTO(count, avg, max, min, sum);
    }
}
