package org.launchcode.repairrundown.Models.Forms;

import org.hibernate.validator.constraints.NotEmpty;
import org.jetbrains.annotations.NotNull;

public class ProcessExistingUser {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String password;


    public ProcessExistingUser(){}

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
