package crud_persona.service;
import org.springframework.stereotype.Service;
import crud_persona.model.Person;
import crud_persona.repository.RepositoryPerson;
import java.util.List;

@Service
public class ServicePerson {
	private final RepositoryPerson repository = new RepositoryPerson();
	
	public List<Person> getElements(){
		return repository.getPersonas();
	}
	
	public void addElement(Person persona) {
		repository.save(persona);
	}
	
	public void modifyElement(Person persona) {
		repository.modifyPerson(persona);
	}
	
	public void removeElement(int id) {
		repository.removePerson(id);
	}
	
}
