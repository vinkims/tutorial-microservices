package ke.kigen.userservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ke.kigen.userservice.dto.ResponseDto;
import ke.kigen.userservice.model.User;
import ke.kigen.userservice.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        User savedUser = userService.saveUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) {

        ResponseDto responseDto = userService.getUser(userId);

        return ResponseEntity.ok(responseDto);
    }
}
