package ua.fesenko.spring.FirstSecurityApp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "year_of_birth")
    private int year_of_birth;
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

}
