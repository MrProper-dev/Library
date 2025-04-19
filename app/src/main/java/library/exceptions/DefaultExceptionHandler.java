package library.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String anyException(Model model, Exception ex){
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("exception", ex.getCause());
        return "exception.html";
    }
}
