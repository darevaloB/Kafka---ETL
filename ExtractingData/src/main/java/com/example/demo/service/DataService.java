package com.example.demo.service;

import com.example.demo.controller.PersonaController;
import com.example.demo.model.Persona;
import java.util.List;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class DataService {

    private PersonaController mensajeController;
    private RestTemplate restTemplate = new RestTemplate();

        
    public DataService(PersonaController mensajeController) {
        this.mensajeController = mensajeController;
    }
	
        
    @KafkaListener(
            topics = "source_topic"
            
    )
    
 public List Listener (Persona p){
       
        List personas = null;
        personas.add(p);
        return personas;
        
    }
	

}
