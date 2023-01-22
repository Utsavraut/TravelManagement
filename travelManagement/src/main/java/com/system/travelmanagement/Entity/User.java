package com.system.travelmanagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "tms_user_seq_gen", sequenceName = "tms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "tms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name = "password", nullable = false)
    private String password;


}
