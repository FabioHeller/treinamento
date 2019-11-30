package com.codenation.treinamento.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyVO {
    private Long id;
    private String nome;
    private String documento;
    private Integer vagas;
    private String site;
    private AddressVO address;
}
