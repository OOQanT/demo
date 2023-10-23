package library.prac.library.domain.user.userloanhistory;

import jakarta.persistence.*;
import lombok.Getter;

@Entity(name = "user_loan_history")
@Getter
public class UserLoanHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "is_return")
    private boolean isReturn;

    protected UserLoanHistory() {}

    public UserLoanHistory(Long userId, String bookName) {
       this.userId = userId;
       this.bookName = bookName;
       this.isReturn = false;
    }

    public void isReturn(){
        this.isReturn = true;
    }
}
