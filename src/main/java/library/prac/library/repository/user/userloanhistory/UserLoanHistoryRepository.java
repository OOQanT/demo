package library.prac.library.repository.user.userloanhistory;

import library.prac.library.domain.user.userloanhistory.UserLoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory,Long> {
    Optional<UserLoanHistory> findByUserIdAndBookName(Long userId,String bookName);
}
