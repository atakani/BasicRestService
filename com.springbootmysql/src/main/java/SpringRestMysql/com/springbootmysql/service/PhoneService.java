package SpringRestMysql.com.springbootmysql.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import SpringRestMysql.com.springbootmysql.domain.Phone;
import SpringRestMysql.com.springbootmysql.repository.PhoneRepository;
import java.util.List;;

@Service
public class PhoneService {

	private PhoneRepository phoneRepository;
	
	public PhoneService(PhoneRepository phoneRepository) {
		this.phoneRepository = phoneRepository;
	}
	   public Iterable<Phone> list() {
	        return phoneRepository.findAll();
	    }
	   
	   public Phone save(Phone phone) {
		   
		   return phoneRepository.save(phone);
	   }
	   
	   public void save(List<Phone> phones)	 {
	        phoneRepository.save(phones);
	    }
	   public Phone getphoneById (@PathVariable("id") long id) throws Exception
	   {
	       Phone phone = phoneRepository.findOne(id);
	        
	       if(phone == null) {
	            throw new Exception("Üye bulunamadı: " + id);
	       }
	       return phone;
	   }

}
