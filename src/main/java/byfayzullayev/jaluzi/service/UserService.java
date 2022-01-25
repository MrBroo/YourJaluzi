package byfayzullayev.jaluzi.service;

import byfayzullayev.jaluzi.model.receive.UserSignInReceiveModel;
import byfayzullayev.jaluzi.model.receive.UserSignUpReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.RoleRepository;
import byfayzullayev.jaluzi.repository.UserRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements BaseService {

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
public ApiResponse addUser(UserSignUpReceiveModel userSignUpReceiveModel){

}
}
