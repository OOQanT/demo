package library.prac.library.controller.user;

import library.prac.library.dto.user.UserCreateDto;
import library.prac.library.dto.user.UserResponse;
import library.prac.library.dto.user.UserUpdateDto;
import library.prac.library.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateDto request){
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUser(){
        return userService.getUser();
    }

    @PutMapping("/user")
    public void updateName(@RequestBody UserUpdateDto request){
        userService.nameUpdate(request);
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
}
