package org.launchcode.repairrundown.Models.Forms;

import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class RegistrationForm {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16, message = "Please enter a name between 2 and 16 characters")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16, message = "Please enter a name between 2 and 16 characters")
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16, message = "Please choose a username between 2 and 16 characters")
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 16, message = "Please choose a password between 2 and 16 characters")
    private String password;

    public RegistrationForm(){}

    public RegistrationForm(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
