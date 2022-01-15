package byfayzullayev.jaluzi.entity.user;

import byfayzullayev.jaluzi.entity.BaseEntity;
import byfayzullayev.jaluzi.entity.role.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private Long phoneNumber;

    @ManyToMany
    private List<RoleEntity> roleEntityList;


}


