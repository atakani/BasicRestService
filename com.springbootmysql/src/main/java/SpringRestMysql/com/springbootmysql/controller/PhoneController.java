package SpringRestMysql.com.springbootmysql.controller;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SpringRestMysql.com.springbootmysql.domain.Phone;
import SpringRestMysql.com.springbootmysql.service.PhoneService;

@RestController
@RequestMapping("/phone")
public class PhoneController {

	private PhoneService phoneService;

	public PhoneController(PhoneService phoneService) {
		this.phoneService = phoneService;
	}
	
	  @GetMapping("/list")
	    public Iterable<Phone> list() {
	        return phoneService.list();
	    }
	 
	  @GetMapping("/phonelist/{id}")
	  public Phone phoness(long id) {
	      return phoness(id);
	  }
	  @RequestMapping(value = "{decisionIds}", method = RequestMethod.GET)
	    public Phone findByIds(@PathVariable @NotNull @DecimalMin("0") Set<Long> decisionIds) {
	          System.out.println(decisionIds);
			return findByIds(decisionIds);
	}
}	
