package pro.sky.java.course2.exception.workwithexceptionproject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArraysIsFullException extends RuntimeException {
}
