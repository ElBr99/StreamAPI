package StreamAPI.Task122;

public class Person {
    private String name;
    private String surname;
    private Education education;
    private Sex sex;
    private Integer age;

    public Person(String name, String surname, Education education, Sex sex, Integer age) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Education getEducation() {
        return education;
    }

    public Sex getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
