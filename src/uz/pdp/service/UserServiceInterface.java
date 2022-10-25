package uz.pdp.service;

import uz.pdp.entity.User;
import uz.pdp.memory.DynamicArray;
import uz.pdp.memory.Result;
import uz.pdp.payload.UserDTO;
import uz.pdp.payload.UserEditDTO;

public interface UserServiceInterface {
    DynamicArray<User> users = new DynamicArray<>(5);

    User create(UserDTO newUser);

    User get(String emailOrPhone, String password);

    Result edit(Long userId, UserEditDTO userDTO);

    Result delete(Long userID);

}
