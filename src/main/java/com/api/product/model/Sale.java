package com.api.product.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.product.validate.ValidationMessages;

@Entity
public class Sale {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
	
	@Temporal(TemporalType.DATE)
//	@NotNull(message = ValidationMessages.MESSAGE_INICIALDATE_NOT_NULL)
//	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date inicialDate;

	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd/MM/yyyy")
//	@NotNull(message = ValidationMessages.MESSAGE_LASTDATE_NOT_NULL)
	private Date lastDate;

	@NotNull(message = ValidationMessages.MESSAGE_PRICE_NOT_NULL)
	private BigDecimal price;
	
//	private Status status;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
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
	
}