package lk.ijse.devop.authenticate_microservice.Service;

import lk.ijse.devop.authenticate_microservice.Dto.AdminDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {
    AdminDTO searchUser(String email);
}
