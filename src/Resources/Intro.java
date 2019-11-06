package Resources;

import java.io.Serializable;

public class Intro implements Serializable {

    static final long serialVersionUID = 1L;

    String message = "Connection established with server";


    public String getMessage() {
        return message;
    }
}
