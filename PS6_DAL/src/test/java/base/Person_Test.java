package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {
	
	private static PersonDomainModel person1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		LocalDate today = LocalDate.now();
		person1 = new PersonDomainModel(null);
		person1.setFirstName("A");
		person1.setLastName("B");
		person1.setStreet("111 Main Street");
		person1.setPostalCode(19716);
		person1.setCity("Newark");
		person1.setBirthday(today);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
		PersonDomainModel per;
		per = PersonDAL.getPerson(person1.getpersonID());
		PersonDAL.deletePerson(person1.getpersonID());
		assertNull("removed",per);
	}

	@Test
	public void testAddPerson() {
		PersonDomainModel per;
		per = PersonDAL.getPerson(person1.getpersonID());
		assertNull("no match in database",per);
		PersonDAL.addPerson(person1);
		per = PersonDAL.getPerson(person1.getpersonID());
		assertNotNull("match in database");
	}

	@Test
	public void testGetPersons() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePerson() {
		fail("Not yet implemented");
	}

}
