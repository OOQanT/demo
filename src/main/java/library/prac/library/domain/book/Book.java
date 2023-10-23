package library.prac.library.domain.book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
@Entity(name = "book")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name",length = 255)
    private String name;

    protected Book() {}

    public Book(String name) {
        if(!StringUtils.hasText(name)){
            throw new IllegalArgumentException("잘못된 이름");
        }
        this.name = name;
    }
}
