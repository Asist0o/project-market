package market.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class SizeName {

    @Id
    private Long id;

    @NotBlank
    private String name;

    public SizeName() {}

    public SizeName(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SizeName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SizeName{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
