package testDemo.application.exepction;

import lombok.Getter;

public abstract class ApplicationException extends RuntimeException {

    @Getter
    private final String layout;

    public ApplicationException(Exception e, String layout) {
        super(e);
        this.layout = layout;
    }

    @Override
    public String toString() {
        return "ApplicationException{" +
                "layout='" + layout + '\'' +
                "message='" + getMessage() + '\'' +
                '}';
    }
}
