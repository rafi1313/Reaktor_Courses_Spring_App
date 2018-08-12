package reaktor.reaktorapp.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String acronym;
    @ManyToMany(mappedBy = "editions")
    private Set<User> userSet;

    public Edition() {
    }

    public Edition(String type, String acronym, Set<User> userSet) {
        this.type = type;
        this.acronym = acronym;
        this.userSet = userSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}
