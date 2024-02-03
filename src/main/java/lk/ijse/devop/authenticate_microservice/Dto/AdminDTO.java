package lk.ijse.devop.authenticate_microservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDTO {
    private int id;
    private String username;
    private String password;
    private String email;
    private String usernic;
    private String type;
}
