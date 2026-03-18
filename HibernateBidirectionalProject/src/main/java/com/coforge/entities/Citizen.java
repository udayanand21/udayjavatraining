package com.coforge.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Citizen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;
	private String cname;
	
	
	@OneToOne(mappedBy = "citizen", cascade = CascadeType.ALL)
	private Aadhar aadhar;
	

}
