package s06_Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewFeatures {
public static void main(String[] args) {
	List<User> users = new ArrayList<>();
	users.add(new User(1, "Aleyna"));
	users.add(new User(2, "Ahmet"));
	users.add(new User(3, "Zehra"));
	users.add(new User(4, "Murat"));
	users.add(new User(5, "Yildiz"));
	users.add(new User(6, "Levent"));
	users.add(new User(7, "Elvan"));

	// aslinda burda user parametre sout da method govdesi olmus oluyor.
	// users.stream().forEach(user -> System.out.println(users.toString()));
	users.stream().forEach(user -> {
		System.out.println("Java8");
		System.out.println(user.toString());
	});

	users.stream().forEach(user -> user.talk());
	// method referance bir onceki ile ayni isi yapiyor
	users.stream().forEach(User::talk); 
		
	long count = users.stream().filter(user -> user.id > 5).count();
	System.out.println("count: " + count);
		
	List<User> filteredList = users.stream().filter(user -> user.id > 5)
			.collect(Collectors.toList());
	filteredList.stream().forEach(User::talk);
	// liste elemanlari uzerine oynamalar yapalim
	List<User> mappedList = users.stream()
		.map(user -> new User(user.id + 100, user.name))
		.collect(Collectors.toList());
	mappedList.stream().forEach(user -> System.out.println(user.toString()));
	
	//Bir listeyi baska bir tipe donusturelim. Yani map
	Map<Integer, String> userMap = users.stream()
			.collect(Collectors.toMap(user -> user.id, user -> user.name));
	//burdan Lambda funtion un iki parametre alabildigini de gorduk
	userMap.forEach((key, value) -> System.out.println(key+" : "+value));
	
	
		
}

}

class User {
	int id;
	String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {

		return "User [id=" + id + ", name=" + name + "]";
	}

	public void talk() {
		System.out.println("Hi, I am " + this.name);
	}
}
