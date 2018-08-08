package org.launchcode.repairrundown.Models.Data;

import org.launchcode.repairrundown.Models.Forms.RegistrationForm;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<RegistrationForm,Integer> {

    RegistrationForm findByUsername(String username);
}
