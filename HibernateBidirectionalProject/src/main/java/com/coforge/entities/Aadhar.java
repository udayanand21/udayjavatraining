package com.coforge.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

@Entity
public class Aadhar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long aadharid;
    private String address;
    @OneToOne
    @JoinColumn(name = "cid")
    private Citizen citizen;
    

}