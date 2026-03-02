package com.matt.EduCenter.Controller;
import com.matt.EduCenter.Modelo.User;
import com.matt.EduCenter.Service.UserService;
import com.matt.EduCenter.dto.UserResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> listarUsers() {

        return userService.listarUsers().stream().map(user -> {
                    UserResponse dto = new UserResponse();
                    dto.setId(user.getId());
                    dto.setNombre(user.getNombre());
                    dto.setApellido(user.getApellido());
                    dto.setEmail(user.getEmail());
                    dto.setRol(user.getRol().name());
                    return dto;
                })
                .toList();
    }

    @PostMapping
    public User crearUser(@RequestBody User user) {
        return userService.guardarUser(user);
    }

}