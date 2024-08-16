package crud_persona.repository;

import crud_persona.model.Person;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryPerson {
	private final String file = "personas.txt";
	
	public List<Person> getPersonas(){
		List<Person> personas = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String linea;
			while ((linea = br.readLine())!=null) {
				String[] data = linea.split(",");
				Person person = new Person(Integer.parseInt(data[0]),data[1],data[2],data[3]);
				personas.add(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personas;
	}

	
	public void save(Person person) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
			bw.write(person.getId() + "," + person.getName()+","+ person.getLastname()+","+ person.getEmail());
			bw.newLine();
			System.out.println("Persona agregada"+person);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyPerson(Person modifyPerson) {
		List<Person> personas = getPersonas();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			for(Person person : personas) {
				if(person.getId() == modifyPerson.getId()) {
					bw.write(modifyPerson.getId()+","+ modifyPerson.getName()+","+ modifyPerson.getLastname()+","+ modifyPerson.getEmail());
				}else {
					bw.write(person.getId() + "," + person.getName()+","+ person.getLastname()+","+ person.getEmail());
				}
				bw.newLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removePerson(int id) {
		List<Person> personas = getPersonas();
		try (BufferedWriter bw = new BufferedWriter (new FileWriter(file))){
			for(Person person: personas) {
				if(person.getId()!= id) {
					bw.write(person.getId() + "," + person.getName()+","+ person.getLastname()+","+ person.getEmail());
					bw.newLine();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
