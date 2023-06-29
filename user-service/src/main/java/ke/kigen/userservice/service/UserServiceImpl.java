package ke.kigen.userservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import ke.kigen.userservice.dto.DepartmentDto;
import ke.kigen.userservice.dto.ResponseDto;
import ke.kigen.userservice.dto.UserDto;
import ke.kigen.userservice.model.User;
import ke.kigen.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // private RestTemplate restTemplate;

    private WebClient webClient;
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate
        //     .getForEntity("http://localhost:5088/api/departments/" + user.getDepartmentId(), DepartmentDto.class);

        // DepartmentDto departmentDto = responseEntity.getBody();

        // System.out.println(responseEntity.getStatusCode());

        DepartmentDto departmentDto = webClient.get()
            .uri("http://localhost:5088/api/departments/" + user.getDepartmentId())
            .retrieve()
            .bodyToMono(DepartmentDto.class)
            .block();

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
    
}
