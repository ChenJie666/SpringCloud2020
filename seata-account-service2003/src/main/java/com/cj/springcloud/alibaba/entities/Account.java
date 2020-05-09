package com.cj.springcloud.alibaba.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Account {

    private Long userId;

    private BigDecimal total;

    private BigDecimal userd;

    private BigDecimal residue;

}
