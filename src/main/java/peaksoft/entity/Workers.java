package peaksoft.entity;

import javax.persistence.*;

@Entity
@Table (name = "workers")
public class Workers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id ;
    @Column (name = "name")
    private String name ;
    @Column (name = "last_name")
    private String surname ;
    @Column (name = "age")
    private int age ;

    public Workers(String name, String surname,  int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Workers() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
