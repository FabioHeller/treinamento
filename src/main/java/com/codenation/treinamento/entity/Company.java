package com.codenation.treinamento.entity;

import com.codenation.treinamento.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(max = 255)
    private String name;

    @Column(name = "document")
    @NotNull
    @Size(max = 17)
    private String document;

    @Column(name = "vacancies")
    @NotNull
    private int vacancies;

    @Column(name = "site")
    @NotNull
    @Size(max = 32)
    private String site;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList;


    @ColumnAnnotation(position = 2, text = "My address is ")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;
}
