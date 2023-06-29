package ke.kigen.userservice.service;

import ke.kigen.userservice.dto.ResponseDto;
import ke.kigen.userservice.model.User;

public interface UserService {
    
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
