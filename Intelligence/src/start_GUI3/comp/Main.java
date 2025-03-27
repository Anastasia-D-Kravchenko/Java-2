package start_GUI3.comp;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person("C", "C", 1990);
        Person p2 = new Person("A", "A", 2000);
        Person p3 = new Person("D", "D", 1980);
        Person p4 = new Person("B", "B", 2010);

        Person[] people = {p1, p2, p3, p4};

        System.out.println( Arrays.toString(people) );
        Arrays.sort(people);
        System.out.println( Arrays.toString(people) );

        Comparator<Person> byName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(people, byName);
        System.out.println( Arrays.toString(people) );

        // JUST TEASER
        Arrays.sort(people, (o1, o2) -> {return o2.getSurname().compareTo(o1.getSurname());});
        System.out.println( Arrays.toString(people) );
    }
}
