package com.employee.app.CRUD.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMS")
public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "First_Name",nullable = false)
    private String FirstName;

    @Column(name = "Last_Name",nullable = false)
    private String LastName;

    @Column(name = "EMAIL",nullable = false,unique = true )
    private String email;

    @Column(name = "Date",nullable = false,unique = true )
    private String date;
}
