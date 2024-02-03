package lk.ijse.devop.authenticate_microservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoginRes {
    private String email;
    private String code;
    private String role;
}
