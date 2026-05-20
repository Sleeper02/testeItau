package Teste.testeItau.Estatistica;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class EstatisticaDTO {

    private int count;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private BigDecimal sum;


}
