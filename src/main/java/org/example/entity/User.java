package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Embedded
    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date")) // Repeatable - может быть несколько
    private PersonalInfo personalInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

}
