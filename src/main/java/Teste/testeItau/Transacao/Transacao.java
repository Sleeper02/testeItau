package Teste.testeItau.Transacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Transacao {
    private BigDecimal valor; //Usando BidDecimal pq precisamos ser mto preciso
    private OffsetDateTime dataHora; //padrão iso 8601
}
