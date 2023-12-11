package com.akdenizbank.mls.user;

import com.akdenizbank.mls.util.StringSequenceIdentifier;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class EmployeeUser extends AppUser {
    //TODO: Create Repository-Service-Controller for employee user  - Done !

}
