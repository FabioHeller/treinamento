package com.codenation.treinamento.entity;

import com.codenation.treinamento.annotation.ColumnAnnotation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "document", nullable = false, length = 100)
    private String document;

    @Column(name = "age")
    private int age;

    @Column(name = "login", nullable = false, length = 100)
    private String login;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @ColumnAnnotation(position = 2, text = "My company is ")
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company comapany;

    @ColumnAnnotation(position = 3, text = "My address is ")
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

}
