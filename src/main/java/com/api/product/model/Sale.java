package com.api.product.model;

import com.api.product.validate.ValidationMessages;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Sale {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	@Column(name = "inicialDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date inicialDate;

	@NotNull
	@Column(name = "lastDate", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date lastDate;
	
	@NotNull(message = ValidationMessages.MESSAGE_PRICE_NOT_NULL)
	@Column(name = "price", nullable = false)
	private BigDecimal price;

	@NotNull
	@Column(name = "status", nullable = false)
	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getInicialDate() {
		return inicialDate;
	}

	public void setInicialDate(Date inicialDate) {
		this.inicialDate = inicialDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}