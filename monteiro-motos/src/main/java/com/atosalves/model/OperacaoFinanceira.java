package com.atosalves.model;

import com.atosalves.enums.TipoTransacao;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperacaoFinanceira {

	private TipoTransacao tipoTransacao;
	private LocalDateTime data;
	private float valor;
}
