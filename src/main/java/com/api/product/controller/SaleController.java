package com.api.product.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.product.model.Sale;
import com.api.product.repository.SalesRepository;

@RestController
public class SaleController {

	@Autowired
	SalesRepository saleRepository;
	
	@RequestMapping(value = "/sale/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public void savingSale(@RequestBody Sale sale) {
			this.saleRepository.save(sale);
	}
	
	@RequestMapping(value = "/sale/get", method = RequestMethod.GET)
	public List<Sale> getSales() {
		return saleRepository.findAll();
	}
	
	@RequestMapping(value = "/sale/{id}", method = RequestMethod.GET)
	public Sale findById(@PathVariable BigDecimal id) {
		return saleRepository.findOne(id);
	}
	
	@RequestMapping(value = "/sale/price/{price}/{price2}", method = RequestMethod.GET)
	public List<Sale> findByPrice(@PathVariable BigDecimal price, @PathVariable BigDecimal price2) {
		return saleRepository.findByPrice(price, price2);
	}
	
	@RequestMapping(value = "/sale/date/inicial={inicialDate}/last={lastDate}", method = RequestMethod.GET)
	public List<Sale> findByDate(@PathVariable Date inicialDate, @PathVariable Date lastDate) {
//		Date data1 = inicialDate.getTime();
//		Date data2 = inicialDate.getTime();
		String inicialDateString = new SimpleDateFormat("dd/MM/yyyy").format(inicialDate.getTime());
		String lastDateString = new SimpleDateFormat("dd/MM/yyyy").format(lastDate.getTime());
		return saleRepository.findByDate(inicialDateString,lastDateString);
	}
	
	@RequestMapping(value = "/sale/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable BigDecimal id) {
		this.saleRepository.delete(id);
	}
	
	
}
