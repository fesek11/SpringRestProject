package ua.fesenko.spring.FirstSecurityApp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "year_of_birth")
    private int year_of_birth;
    @Column(name = "password")
    private String password;

    public Person(String username, int year_of_birth) {
        this.username = username;
        this.year_of_birth = year_of_birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", password='" + password + '\'' +
                '}';
    }
}
