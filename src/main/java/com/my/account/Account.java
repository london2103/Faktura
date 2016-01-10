package com.my.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.my.order.OrderSummary;
import com.my.warehouse.operative.WarehouseOperative;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQueries({
		@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
})
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String email;
	
	@JsonIgnore
	private String password;

	private String role = "ROLE_USER";

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "customer")
	private List<OrderSummary> orderSummaries;

	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
	private WarehouseOperative warehouseOperative;

    protected Account() {

	}
	
	public Account(String email, String password, String role) {
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<OrderSummary> getOrderSummaries() {
		return orderSummaries;
	}

	public void setOrderSummaries(List<OrderSummary> orderSummaries) {
		this.orderSummaries = orderSummaries;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WarehouseOperative getWarehouseOperative() {
		return warehouseOperative;
	}

	public void setWarehouseOperative(WarehouseOperative warehouseOperative) {
		this.warehouseOperative = warehouseOperative;
	}
}
