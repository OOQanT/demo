package library.prac.library.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {

    private String name;
    private Integer age;

    public UserCreateDto(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
