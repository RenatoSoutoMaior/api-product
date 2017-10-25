package com.api.product.controller;

import com.api.product.model.Sale;
import com.api.product.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public Sale findById(@PathVariable Long id) {
		return saleRepository.findOne(id);
	}
	
	@RequestMapping(value = "/sale/price/{price}/{price2}", method = RequestMethod.GET)
	public List<Sale> findByPrice(@PathVariable BigDecimal price, @PathVariable BigDecimal price2) {
		return saleRepository.findByPrice(price, price2);
	}
	
	@RequestMapping(value = "/sale/date/{inicialDate}/{lastDate}", method = RequestMethod.GET)
	public List<Sale> findByDate(@PathVariable String inicialDate, @PathVariable String lastDate) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateInicial = df.parse(inicialDate);
		Date dateLast = df.parse(lastDate);
		
		return saleRepository.findByDate(dateInicial, dateLast);
	}
	
	@RequestMapping(value = "/sale/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		this.saleRepository.delete(id);
	}
}
