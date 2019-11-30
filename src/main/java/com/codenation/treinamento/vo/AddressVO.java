package com.codenation.treinamento.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressVO {
    private Long id;
    private String zip_code;
    private String street;
    private int number;
    private String district;
    private String city;
    private String country;

}
