package students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Mainstreet 1", "Chicago", "57889");
		Student student = new Student(1, "Frank Brown", "234123432", "fb@gmail.com");
		student.setAddress(address);
		student.addGrade(new Grade("Programming 1", "A+"));
		student.addGrade(new Grade("RDBMS", "A-"));
		studentRepository.save(student);
		address = new Address("22 Rodeo Dr.", "Los Angeles", "33889");
		student = new Student(2, "Sue Ellen", "334221123", "sueellen@gmail.com");
		student.setAddress(address);
		student.addGrade(new Grade("Programming 1", "B+"));
		student.addGrade(new Grade("Software Engineering", "A-"));
		studentRepository.save(student);
		//get customers
		System.out.println(studentRepository.findById(1).get());
		System.out.println(studentRepository.findById(2).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(studentRepository.findAll());

		System.out.println("-----------find by name ----------------");
		List<Student> students = studentRepository.findByName("Sue Ellen");
		students.forEach(s->System.out.println(s));
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhone("234123432"));

		System.out.println("-----------find by city ----------------");
		students = studentRepository.findByCity("Chicago");
		students.forEach(s->System.out.println(s));

		System.out.println("-----------find by course name ----------------");
		students = studentRepository.findByCourse("Programming 1");
		students.forEach(s->System.out.println(s));

		System.out.println("-----------find by course name and grade----------------");
		students = studentRepository.findByCourseAndGrade("Programming 1", "A+");
		students.forEach(s->System.out.println(s));

	}

}
