package reaktor.reaktorapp.model.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterUserForm {

    @NotBlank(message = "Email nie może być pusty!")
    @Email(message="Niepoprawny format adresu email!")
    private String email;
    @Size(min=6,max=15,message = "Hasło musi mieć do {min} do {max} znaków")
    private String password;
    @NotBlank(message = "Imię nie może być puste!")
    private String firstName;
    @NotBlank(message = "Nazwisko nie może być puste!")
    private String lastName;

    public RegisterUserForm() { }

    public RegisterUserForm(String email,String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
