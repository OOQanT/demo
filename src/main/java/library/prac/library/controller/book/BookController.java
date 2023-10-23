package library.prac.library.controller.book;

import library.prac.library.domain.user.userloanhistory.UserLoanHistory;
import library.prac.library.dto.book.BookCreateDto;
import library.prac.library.dto.user.userloanhistory.CreateLoanHistory;
import library.prac.library.dto.user.userloanhistory.UpdateLoanHistory;
import library.prac.library.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateDto request){
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody CreateLoanHistory request){
        log.info("request.getUserName() = {}",request.getUserName());
        log.info("request.getBookName() = {}",request.getBookName());
        bookService.loanBook(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody UpdateLoanHistory request){
        log.info("request.getUserName() = {}",request.getUserName());
        log.info("request.getBookName() = {}",request.getBookName());
        bookService.returnBook(request);
    }
}
