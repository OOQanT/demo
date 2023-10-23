package library.prac.library.dto.user;

import lombok.Getter;

@Getter
public class UserUpdateDto {

    private Long id;

    private String name;

    public UserUpdateDto(){

    }

    public UserUpdateDto(Long id,String name){
        this.id = id;
        this.name = name;
    }
}
