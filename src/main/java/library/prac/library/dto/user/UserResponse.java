package library.prac.library.dto.user;

import library.prac.library.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {

    private long id;
    private String name;
    private Integer age;

    public UserResponse(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }
}
