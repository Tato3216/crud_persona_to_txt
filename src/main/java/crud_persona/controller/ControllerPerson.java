package crud_persona.controller;

import crud_persona.model.Person;
import crud_persona.service.ServicePerson;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class ControllerPerson {
	private final ServicePerson service = new ServicePerson();
	
	@GetMapping
	public List<Person> getElements(){
		return service.getElements();
	}
	
	@PostMapping
	public ResponseEntity<String> addElement(@RequestBody Person persona) {
		service.addElement(persona);
		return ResponseEntity.ok("Persona agregada!");
	}
	
	@PutMapping("/{id}")
	public void modifyElement(@PathVariable int id, @RequestBody Person persona) {
		persona.setId(id);
		service.modifyElement(persona);
	}
	
	@DeleteMapping("/{id}")
	public void removeElement(@PathVariable int id) {
		service.removeElement(id);
	}
	
}
