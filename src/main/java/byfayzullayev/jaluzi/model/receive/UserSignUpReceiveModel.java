package byfayzullayev.jaluzi.model.receive;


import byfayzullayev.jaluzi.entity.role.RoleEnam;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignUpReceiveModel {

    @JsonProperty("username")
    @NotEmpty(message = "username bo`sh bo`lishi kerakemas")
    private String username;

    @NotEmpty(message = "password bo`sh bo`lishi kerakemas")
    private String password;

    @JsonProperty("phone_number")
    @NotBlank(message = "telefon raqam bo`sh bo`lishi kerakemas")
    private String phoneNumber;

    @JsonProperty("user_role")
    private RoleEnam roleEnam;

}
