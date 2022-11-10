package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String mobileNo;
	private String password;
	private String email;
	private Integer type ;
	
	
//
//    @OneToMany( mappedBy = "customer", cascade = CascadeType.ALL)

	@OneToMany(cascade= CascadeType.ALL)
@JoinTable(name="cust_prod",joinColumns=@JoinColumn(name="prod"),inverseJoinColumns=@JoinColumn(name="eid"))
    private List<product> productList = new ArrayList<>();

//	
//	
//	@OneToMany(cascade = CascadeType.ALL , mappedBy = "customer")
//	@JsonIgnore
//    private List<product> bd = new ArrayList<>();

}
