package lk.ijse.devop.user_mircoservice.service.impl;

import lk.ijse.devop.user_mircoservice.dto.UserDTO;
import lk.ijse.devop.user_mircoservice.entity.User;
import lk.ijse.devop.user_mircoservice.exception.*;
import lk.ijse.devop.user_mircoservice.repo.UserRepo;
import lk.ijse.devop.user_mircoservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO searchUserByEmail(String email) throws UserNotFoundException {
        User user = userRepo.findByEmail(email);
        System.out.println(user);
        List<String> roles = new ArrayList<>();
        roles.add("user");
        UserDTO userDetails = modelMapper.map(user, UserDTO.class);
        return userDetails;
    }

    @Override
    public void updateUser(UserDTO email) throws UpdateFailException {

    }

    @Override
    public int addUsers(UserDTO email) throws CreateFailException {
        return 0;
    }

    @Override
    public void deleteUser(String email) throws DeleteFailException {
        try {
            int id = userRepo.findByEmail(email).getId();
            userRepo.deleteById(id);
        }catch (Exception e){
            throw new DeleteFailException("Operation Fail", e);
        }
    }

    @Override
    public List<UserDTO> getAll(String email) throws UserNotFoundException {
        return null;
    }
}
