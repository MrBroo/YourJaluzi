package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
