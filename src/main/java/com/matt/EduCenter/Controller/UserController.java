package com.matt.EduCenter.Controller;
import com.matt.EduCenter.Modelo.User;
import com.matt.EduCenter.Service.UserService;
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
    public List<User> listarUsers() {
        return userService.listarUsers();
    }

    @PostMapping
    public User crearUser(@RequestBody User user) {
        return userService.guardarUser(user);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        try {
            User usuarioLogueado = userService.login(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(usuarioLogueado);
        } catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}