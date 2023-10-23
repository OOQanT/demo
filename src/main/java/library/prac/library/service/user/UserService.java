package library.prac.library.service.user;

import library.prac.library.domain.user.User;
import library.prac.library.dto.user.UserCreateDto;
import library.prac.library.dto.user.UserResponse;
import library.prac.library.dto.user.UserUpdateDto;
import library.prac.library.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserCreateDto request){
        userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUser(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public void nameUpdate(UserUpdateDto request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.setName(request.getName());
    }

    @Transactional
    public void deleteUser(String name){
        User user = userRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }
}
