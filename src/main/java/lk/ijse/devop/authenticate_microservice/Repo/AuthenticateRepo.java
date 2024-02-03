package lk.ijse.devop.authenticate_microservice.Repo;

import lk.ijse.devop.authenticate_microservice.Entity.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AuthenticateRepo extends CrudRepository<Admin, String> {

    Admin findByEmail(String email);
}
