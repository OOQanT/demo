package library.prac.library.service.book;

import library.prac.library.domain.book.Book;
import library.prac.library.domain.user.User;
import library.prac.library.domain.user.userloanhistory.UserLoanHistory;
import library.prac.library.dto.book.BookCreateDto;
import library.prac.library.dto.user.userloanhistory.CreateLoanHistory;
import library.prac.library.dto.user.userloanhistory.UpdateLoanHistory;
import library.prac.library.repository.book.BookRepository;
import library.prac.library.repository.user.UserRepository;
import library.prac.library.repository.user.userloanhistory.UserLoanHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    @Transactional
    public void saveBook(BookCreateDto request){
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(CreateLoanHistory request){
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(),book.getName()));
    }

    @Transactional
    public void returnBook(UpdateLoanHistory request){
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        UserLoanHistory userLoanHistory = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), book.getName())
                .orElseThrow(IllegalArgumentException::new);
        userLoanHistory.isReturn();
    }

}
