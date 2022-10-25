package uz.pdp.service;

import uz.pdp.entity.User;
import uz.pdp.memory.Result;
import uz.pdp.payload.UserDTO;
import uz.pdp.payload.UserEditDTO;

public class UserService implements UserServiceInterface {
    @Override
    public User create(UserDTO newUser) {
//        Result result = new Result();
        if (!isHere(newUser)) {
            User user = new User();
            user.setEmail(newUser.getEmail());
            user.setFullName(newUser.getFullName());
            user.setPhone(newUser.getPhone());
            user.setPassword(newUser.getPassword());
            users.add(user);
//            result.setSuccess(true);
//            result.setMessage("New user successfully created");
            return user;
        }
        return null;
    }

    @Override
    public User get(String emailOrPhone, String password) {
//        User user = null;
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = (User) users.get(i);
            if ((userI.getEmail().equals(emailOrPhone)
                    || userI.getPhone().equals(emailOrPhone))
                    && userI.getPassword().equals(password)) {
                return userI;
            }
        }
        return null;

    }

    @Override
    public Result edit(Long userId, UserEditDTO userEditDTO) {
        Result result = new Result();
        User user = (User) users.get(userId.intValue());
        if (!isHere(userId, userEditDTO.getPhone())) {

            user.setPassword(userEditDTO.getPassword());
            user.setFullName(userEditDTO.getFullName());
            user.setPhone(userEditDTO.getPhone());
            users.set(userId.intValue(), user);
            result.setSuccess(true);
            result.setMessage("Successfully edited");
        } else {
            result.setMessage("User with phone " + userEditDTO.getPhone() + "already exists");
        }
        return result;
    }

    @Override
    public Result delete(Long userId) {
        Result result = new Result();
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = (User) users.get(i);
            if (userI.getId().equals(userId)) {
                result.setSuccess(users.remove(userI));
                result.setMessage("User successfully deleted");
                return result;
            }
        }
        result.setMessage("User is not removed");
        return result;
    }

    private boolean isHere(UserDTO user) {
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = (User) users.get(i);
            if (userI != null &&
                    (userI.getEmail().equals(user.getEmail()) ||
                            userI.getPhone().equals(user.getPhone()))) {
                return true;
            }
        }
        return false;
    }

    private boolean isHere(Long userId, String phone) {
        User userI;
        for (int i = 0; i < users.size(); i++) {
            userI = (User) users.get(i);
            if (userI != null && !userI.getId().equals(userId) && userI.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }
}
