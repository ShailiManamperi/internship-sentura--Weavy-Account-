package lk.ijse.devop.user_mircoservice.api;

import lk.ijse.devop.user_mircoservice.dto.UserDTO;
import lk.ijse.devop.user_mircoservice.dto.sec.ErrorRes;
import lk.ijse.devop.user_mircoservice.dto.sec.LoginReq;
import lk.ijse.devop.user_mircoservice.dto.sec.LoginRes;
import lk.ijse.devop.user_mircoservice.exception.CreateFailException;
import lk.ijse.devop.user_mircoservice.exception.UserNotFoundException;
import lk.ijse.devop.user_mircoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserApi {
    @Autowired
    UserService userService;
    @PostMapping()
    public ResponseEntity login(@RequestBody LoginReq loginReq) {
        try {
            UserDTO user = userService.searchUserByEmail(loginReq.getEmail());
            String email = user.getEmail();
            LoginRes loginRes = new LoginRes(email);
            return ResponseEntity.ok(loginRes);
        } catch (UserNotFoundException e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, "Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        } catch (Exception e) {
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PostMapping(value = "/{id:\\d+}", consumes = "multipart/form-data")
    public ResponseEntity<UserDTO> save(@RequestPart(value = "uid") String uid,
                                        @RequestPart(value = "display_name")String display_name,
                                        @RequestPart(value = "email") String email,
                                        @RequestPart(value = "given_name") String given_name,
                                        @RequestPart(value = "middle_name") String middle_name,
                                        @RequestPart(value = "name") String name,
                                        @RequestPart(value = "family_name") String family_name,
                                        @RequestPart(value = "nickname") String nickname,
                                        @RequestPart(value = "phone_number") String phone_num,
                                        @RequestPart(value = "comment") String comment,
                                        @RequestPart(value = "directory_id") int directory_id,
                                        @RequestPart(value = "picture_id") int picture_id,
                                        @RequestPart(value = "avatar_url") String avatar_url,
                                        @RequestPart(value = "objects") Object metadata,
                                        @RequestPart(value = "tags") String[] tags,
                                        @RequestPart(value = "presence") String presence,

    ){
        System.out.println(nicNo);
        System.out.println(nicFront);
        try {
            UserDTO userDTO = new UserDTO();
            userDTO.set_suspended();


            int id = userService.addUsers(userDTO);
            userDTO.setId(id);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (CreateFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
