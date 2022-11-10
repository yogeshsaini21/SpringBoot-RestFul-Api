
package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "product")
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productID;
	private String Name;
	
	private Integer customerID;
//	
//	 @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	 @JoinColumn(name="customerId")
//	private Customer customer;
//	@ManyToOne(cascade=CascadeType.ALL)
//	private Customer customer;
	
}
