package SpringRestMysql.com.springbootmysql;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import SpringRestMysql.com.springbootmysql.domain.Phone;
import SpringRestMysql.com.springbootmysql.service.PhoneService;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    @Bean
    CommandLineRunner runner(PhoneService phoneService) {
    	return args ->{
    		//json'i okuma basliyor
    		
    		ObjectMapper mapper =new ObjectMapper();            
    		// for Jackson version 1.X        
    		// for Jackson version 2.X
    		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    		
			TypeReference<List<Phone>> typeReference = new TypeReference<List<Phone>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/devices.json");
			try {
				List<Phone> users = mapper.readValue(inputStream,typeReference);
				phoneService.save(users);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
    	};
    	
    }

}
