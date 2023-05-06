public class PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if(age < 0 || age > 140) {
            throw new IllegalArgumentException(
                    "Возраст не подходит - у вас он -" + age
            );
        }
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException(
                    "Имя нужно обязательнно "
            );
        }

        if (surname == null) {
            throw new IllegalStateException(
                    "Фамилия нужно обязательнно"
            );
        }

        Person person;
        if (age == -1) {
            person = new Person(name,surname);
        } else {
            person = new Person(name, surname,age);
        }

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }
}
