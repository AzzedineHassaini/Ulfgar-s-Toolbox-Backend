package be.tftic.java.ulfgarstoolbox.common.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        StackTraceElement element = this.getStackTrace()[0];

        return this.getClass().getSimpleName() + " thrown in : " + element.getFileName() +
                " in method " + element.getMethodName() + " at line number " +
                element.getLineNumber() + " with message " + this.getMessage();
    }
}
