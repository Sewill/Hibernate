package ManyToOne.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "people_min")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "middleName")
    private String middleName;
    @Column()
    private int year;

    public People() {
    }

    public People(String firstName, String lastName, String middleName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * вообще дя того чтобы сделать связь не обязательно прописывать обратную связь,
     * она нужна тлько для того что бы мы могли найти все связанные элементы с данным объектом
     * автоматический, не прописывая дополнительных запросов
     */

    @OneToMany(
            targetEntity = Phone.class, //является обязательный параметром, указывает с какой таблицей была создана связь
            mappedBy = "people", //является обязательным параметром, ссылается на имя поля в том классе который создает связь с этой таблицей
            //то есть private People people; а не имя таблицы
            fetch = FetchType.LAZY, // не обязательный параметр, по умолчанию принимает значение LAZY что означает,
            // что связанные элементы не будут автоматический подтягиваться при запросе к объекту данного класса
            orphanRemoval = true, //разрешение каскадного удаления
            cascade = CascadeType.ALL
            /*  - cascade="none" - значение по умолчанию. Hibernate будет игнорировать ассоциации, поэтому разруливать зависимости придется самостоятельно.
                - cascade="save-update" говорит Hibernate'у, что разруливать зависимости необходимо при комите транзакции в которой делается save() или update() объекта. Суть разруливания заключается в том, что новые объекты, с которыми есть ассоциации у нашего, будут сохранены до него. Это позволяет обойти constraint-violations.
                - cascade="delete" говорит Hibernate'у, что надо разруливать зависимости при удалении объекта.
                - cascade="all" обозначает выполнение каскадных операций при save-update и delete.
                - cascade="all-delete-orphan" обозначает то же самое, что и cascade="all", но к тому же Hibernate удаляет любые связанные сущности, удаленные из ассоциации (например, из коллекции).
                - cascade="delete-orphan" обозначает, что Hibernate будет удалять любые сущности, которые были удалены из ассоциации.*/
    )
    private List<Phone> phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
