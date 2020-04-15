package com.rabbitmq.order.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public record OrderDto(Integer id, @NotNull String descricao, @NotNull BigDecimal valor)
    implements Serializable {

}
