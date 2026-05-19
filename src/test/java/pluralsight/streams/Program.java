package pluralsight.streams;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Olivia: 19
        Person person1 = new Person("Liam", "Carter", 22);
        Person person2 = new Person("Sophia", "Nguyen", 31);
        Person person3 = new Person("Ethan", "Martinez", 27);
        Person person4 = new Person("Olivia", "Patel", 19);
        Person person5 = new Person("Noah", "Kim", 45);
        Person person6 = new Person("Ava", "Robinson", 38);
        Person person7 = new Person("Mason", "Hernandez", 29);
        Person person8 = new Person("Isabella", "Thompson", 24);
        Person person9 = new Person("Lucas", "Singh", 33);
        Person person10 = new Person("Mia", "Anderson", 41);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        people.add(person9);
        people.add(person10);

        List<Person> matchingPeople = findMatchPeople(scan);
        double averageAge = getAverageAge();
        Person oldestPerson = getOldestPerson();
        Person youngestPerson = getYoungestPerson();


    }

    private static List<Person> findMatchPeople(Scanner scan) {

        System.out.print("Enter the name your looking for: ");
        String userInput = scan.nextLine();


        List<Person> matchingPeople = people.stream().filter(person ->
                userInput.equalsIgnoreCase(person.getFirstName()) || userInput.equalsIgnoreCase(person.getLastName())).toList();
        matchingPeople.forEach(System.out::println);
        return matchingPeople;
    }

    private static double getAverageAge() {
        double totalAge = people.stream().mapToDouble(Person::getAge).sum();
        double averageAge = totalAge / people.size();
        System.out.println("Average age of people: " + averageAge);
        return averageAge;
    }

    private static Person getOldestPerson() {
        Person oldestPerson = null;
        for (Person person : people) {
            if (oldestPerson == null) {
                oldestPerson = person;
            }
            if (oldestPerson.getAge() < person.getAge()) {
                oldestPerson = person;
            }
        }
        System.out.println("Oldest person: " + oldestPerson);
        return oldestPerson;
    }

    private static Person getYoungestPerson() {
        Person youngestPerson = null;
        for (Person person : people) {
            if (youngestPerson == null) {
                youngestPerson = person;
            }
            if (youngestPerson.getAge() > person.getAge()) {
                youngestPerson = person;
            }
        }
        System.out.println("Youngest person: " + youngestPerson);
        return youngestPerson;
    }
}
