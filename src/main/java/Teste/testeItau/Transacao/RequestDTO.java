package Teste.testeItau.Transacao;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestDTO {

    @NotNull(message = "O valor da transação deve ser preenchido")
    @PositiveOrZero (message = "O valor da transação deve ser maior ou igual a zero")
    private BigDecimal valor;

    @NotNull (message = "A data e a hora deve ser preenchida")
    private OffsetDateTime dataHora;
}
