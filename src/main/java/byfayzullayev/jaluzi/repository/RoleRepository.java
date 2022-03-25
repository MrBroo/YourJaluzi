package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.role.RoleEnum;
import byfayzullayev.jaluzi.entity.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByRoleEnum(RoleEnum roleEnam);

}
