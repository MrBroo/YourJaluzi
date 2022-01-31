package byfayzullayev.jaluzi.service;

import byfayzullayev.jaluzi.entity.role.RoleEnam;
import byfayzullayev.jaluzi.entity.user.UserEntity;
import byfayzullayev.jaluzi.model.receive.UserSignInReceiveModel;
import byfayzullayev.jaluzi.model.receive.UserSignUpReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.RoleRepository;
import byfayzullayev.jaluzi.repository.UserRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements BaseService {

    @Value("${jwt.secret}")
    private String jwtSecretKey;
    @Value("${jwt.expiry.date}")
    private String jwtExpiryDate;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
    }

    public ApiResponse addUser(UserSignUpReceiveModel userSignUpReceiveModel) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userSignUpReceiveModel.getUsername());
        if (optionalUserEntity.isPresent())
            return USER_EXIST;

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userSignUpReceiveModel.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userSignUpReceiveModel.getPassword()));

        if (userSignUpReceiveModel.getRoleEnam() == null)
            userEntity.setRoleEntityList(List.of(roleRepository.findByRoleEnum(RoleEnam.USER)));
        else
            userEntity.setRoleEntityList(List.of(roleRepository.findByRoleEnum(userSignUpReceiveModel.getRoleEnam())));
        userRepository.save(userEntity);
        return SUCCESS;
    }

    public ApiResponse login(
            UserSignInReceiveModel userSignInReceiveModel
    ) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUsername(userSignInReceiveModel.getUsername());
        if (optionalUserEntity.isEmpty())
            return USER_NOT_FOUND;
        String token = this.generateToken(optionalUserEntity.get());
        SUCCESS.setData(token);
        return SUCCESS;


    }

    private String generateToken(UserEntity userEntity) {
        try {
            return Jwts.builder().signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(jwtExpiryDate)))
                    .setSubject(userEntity.getUsername())
                    .compact();
        } catch (Exception e) {
            return null;
        }
    }
}
