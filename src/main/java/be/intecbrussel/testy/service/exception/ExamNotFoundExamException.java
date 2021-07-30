package be.intecbrussel.testy.service.exception;

public class ExamNotFoundExamException extends RuntimeException {

    public ExamNotFoundExamException() {
        super("Exam NOT found!");
    }

    public ExamNotFoundExamException(String message) {
        super(message);
    }
}
