package com.meditech.docseeker.healing.domain.model.entity;

import com.meditech.docseeker.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patients")
public class Patient extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dni")
    private String dni;

    @Column(name = "genre")
    private String genre;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "cell1")
    private Long cell1;

    @Column(name = "password")
    private String password;

    @Column(name = "photo")
    private String photo;

}

