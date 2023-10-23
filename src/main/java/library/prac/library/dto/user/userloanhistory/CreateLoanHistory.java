package library.prac.library.dto.user.userloanhistory;

import lombok.Getter;

@Getter
public class CreateLoanHistory {

    private String userName;
    private String bookName;

    public CreateLoanHistory() {}

    public CreateLoanHistory(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }
}
