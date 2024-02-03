package lk.ijse.devop.user_mircoservice.service;


import lk.ijse.devop.user_mircoservice.dto.UserDTO;
import lk.ijse.devop.user_mircoservice.exception.*;

import java.util.List;

public interface UserService {
    UserDTO searchUserByEmail(String email) throws UserNotFoundException;
    void updateUser(UserDTO email) throws UpdateFailException;
    int addUsers(UserDTO email) throws CreateFailException;
    void deleteUser(String email) throws DeleteFailException;
    List<UserDTO> getAll(String email) throws UserNotFoundException;
}
