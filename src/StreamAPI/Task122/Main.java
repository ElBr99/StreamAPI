package StreamAPI.Task122;

import java.util.*;
import java.util.stream.Collectors;

import static StreamAPI.Task122.Education.HIGHER;
import static StreamAPI.Task122.Sex.MAN;
import static StreamAPI.Task122.Sex.WOMAN;


public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> surnames = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        enrichPersonsCollection(persons, names, surnames);

        //1. Найти количество несовершеннолетних (т.е. людей младше 18 лет).
        long countAge = countByAgeLessThan(persons, 18);
        System.out.println(countAge);


        // 2.Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        List<String> list = getRecruitList(persons, 18, 27, MAN);

        // 3.Получить отсортированный по фамилии список потенциально работоспособных людей
        // с высшим образованием в выборке (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).
        List<Person> newList = getWorkablePersonsList(persons, 18, 65, 60, MAN, WOMAN, HIGHER);
    }

    private static List<Person> getWorkablePersonsList(Collection<Person> persons, int ageMin, int ageMaxMan, int ageMaxWoman, Enum maleSex, Enum femaleSex, Enum education) {
        return persons
                .stream()
                .filter(x -> x.getAge() >= ageMin && x.getAge() <= ageMaxWoman && x.getSex() == femaleSex && x.getEducation() == education)
                .filter(x -> x.getAge() >= ageMin && x.getAge() <= ageMaxMan && x.getSex() == maleSex && x.getEducation() == education)
                .sorted(Comparator.comparing(Person::getSurname))
                .collect(Collectors.toList());
    }


    private static List<String> getRecruitList(Collection<Person> persons, int ageMin, int ageMax, Enum sex) {
        return persons
                .stream()
                .filter(x -> x.getAge() >= ageMin && x.getAge() <= ageMax && x.getSex() == sex)
                .map(Person::getSurname)
                .collect(Collectors.toList());
    }

    private static void enrichPersonsCollection(Collection<Person> persons, List<String> names, List<String> surnames) {
        for (int i = 0; i < 1_000_000; i++) {
            persons.add(new Person(
                            names.get(new Random().nextInt(names.size())),
                            surnames.get(new Random().nextInt(surnames.size())),
                            Education.values()[new Random().nextInt(Education.values().length)],
                            Sex.values()[new Random().nextInt(Sex.values().length)],
                            new Random().nextInt(100)
                    )
            );
        }
    }

    private static long countByAgeLessThan(Collection<Person> persons, int age) {
        return persons
                .stream()
                .filter(x -> x.getAge() < age)
                .count();
    }
}
