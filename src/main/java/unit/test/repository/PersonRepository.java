package unit.test.repository;

import unit.test.data.Person;

public interface PersonRepository {
    Person selectById(String id);

    void insert(Person person);
}
