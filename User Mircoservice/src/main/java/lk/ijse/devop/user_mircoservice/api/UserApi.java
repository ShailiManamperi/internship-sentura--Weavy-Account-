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
                                        @RequestPart(value = "created_at") String created_at,
                                        @RequestPart(value = "modified_at") String modified_at,
                                        @RequestPart(value = "is_suspended") boolean is_suspended,
                                        @RequestPart(value = "is_trashed") boolean is_trashed

    ){

        try {
            UserDTO userDTO = new UserDTO();
            userDTO.setUid(uid);
            userDTO.setDisplay_name(display_name);
            userDTO.setEmail(email);
            userDTO.setGiven_name(given_name);
            userDTO.setMiddle_name(middle_name);
            userDTO.setName(name);
            userDTO.setFamily_name(family_name);
            userDTO.setNickname(nickname);
            userDTO.setPhone_number(phone_num);
            userDTO.setComment(comment);
            userDTO.setDirectory_id(directory_id);
            userDTO.setPicture_id(picture_id);
            userDTO.setMetadata(metadata);
            userDTO.setTags(tags);
            userDTO.setPresence(presence);
            userDTO.setCreated_at(created_at);
            userDTO.setModified_at(modified_at);
            userDTO.set_suspended(is_suspended);
            userDTO.set_trashed(is_trashed);
            int id = userService.addUsers(userDTO);
            userDTO.setId(id);
            return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        } catch (CreateFailException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
