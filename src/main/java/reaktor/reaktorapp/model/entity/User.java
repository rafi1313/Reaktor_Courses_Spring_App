package reaktor.reaktorapp.model.entity;


import javax.persistence.*;
import java.util.Set;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean active;
    private String permission = "USER";
    @ManyToMany
    @JoinTable(name = "user_edition")
    private Set<Edition> editions;
    private int gradeProject1;
    private String gradeDesciptionProject1;
    private int gradeProject2;
    private String gradeDesciptionProject2;
    private int gradeProject3;
    private String gradeDesciptionProject3;
    private int gradeProject4;
    private String gradeDesciptionProject4;

    public User() {}

    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String email, String password, String firstName, String lastName, boolean active, String permission, Set<Edition> editions, int gradeProject1, String gradeDesciptionProject1, int gradeProject2, String gradeDesciptionProject2, int gradeProject3, String gradeDesciptionProject3, int gradeProject4, String gradeDesciptionProject4) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.permission = permission;
        this.editions = editions;
        this.gradeProject1 = gradeProject1;
        this.gradeDesciptionProject1 = gradeDesciptionProject1;
        this.gradeProject2 = gradeProject2;
        this.gradeDesciptionProject2 = gradeDesciptionProject2;
        this.gradeProject3 = gradeProject3;
        this.gradeDesciptionProject3 = gradeDesciptionProject3;
        this.gradeProject4 = gradeProject4;
        this.gradeDesciptionProject4 = gradeDesciptionProject4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Set<Edition> getEditions() {
        return editions;
    }

    public void setEditions(Set<Edition> editions) {
        this.editions = editions;
    }

    public int getGradeProject1() {
        return gradeProject1;
    }

    public void setGradeProject1(int gradeProject1) {
        this.gradeProject1 = gradeProject1;
    }

    public String getGradeDesciptionProject1() {
        return gradeDesciptionProject1;
    }

    public void setGradeDesciptionProject1(String gradeDesciptionProject1) {
        this.gradeDesciptionProject1 = gradeDesciptionProject1;
    }

    public int getGradeProject2() {
        return gradeProject2;
    }

    public void setGradeProject2(int gradeProject2) {
        this.gradeProject2 = gradeProject2;
    }

    public String getGradeDesciptionProject2() {
        return gradeDesciptionProject2;
    }

    public void setGradeDesciptionProject2(String gradeDesciptionProject2) {
        this.gradeDesciptionProject2 = gradeDesciptionProject2;
    }

    public int getGradeProject3() {
        return gradeProject3;
    }

    public void setGradeProject3(int gradeProject3) {
        this.gradeProject3 = gradeProject3;
    }

    public String getGradeDesciptionProject3() {
        return gradeDesciptionProject3;
    }

    public void setGradeDesciptionProject3(String gradeDesciptionProject3) {
        this.gradeDesciptionProject3 = gradeDesciptionProject3;
    }

    public int getGradeProject4() {
        return gradeProject4;
    }

    public void setGradeProject4(int gradeProject4) {
        this.gradeProject4 = gradeProject4;
    }

    public String getGradeDesciptionProject4() {
        return gradeDesciptionProject4;
    }

    public void setGradeDesciptionProject4(String gradeDesciptionProject4) {
        this.gradeDesciptionProject4 = gradeDesciptionProject4;
    }
}