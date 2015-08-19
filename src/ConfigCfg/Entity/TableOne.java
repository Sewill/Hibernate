package ConfigCfg.Entity;

import javax.persistence.*;

/**
 * Created by Savva on 19.08.2015.
 */
@Entity
@Table(name = "table_one_cfg")
public class TableOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column
    private String name;
    @Column
    private String year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
