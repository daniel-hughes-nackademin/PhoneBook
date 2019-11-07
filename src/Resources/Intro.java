package Resources;

import java.io.Serializable;

public class Intro implements Serializable {

    static final long serialVersionUID = 1L;

    String message;

    public Intro(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
