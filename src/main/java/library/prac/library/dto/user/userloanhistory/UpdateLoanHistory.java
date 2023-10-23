package library.prac.library.dto.user.userloanhistory;

import lombok.Getter;

@Getter
public class UpdateLoanHistory {

    private String userName;
    private String bookName;

    public UpdateLoanHistory() {}

    public UpdateLoanHistory(String userName, String bookName) {
        this.userName = userName;
        this.bookName = bookName;
    }
}
