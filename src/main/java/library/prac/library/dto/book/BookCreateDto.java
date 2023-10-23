package library.prac.library.dto.book;

import lombok.Getter;

@Getter
public class BookCreateDto {
    private String name;

    public BookCreateDto() {
    }

    public BookCreateDto(String name) {
        this.name = name;
    }
}
