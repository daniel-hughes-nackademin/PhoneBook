package Resources;

import java.io.Serializable;

public class Response implements Serializable {

    static final long serialVersionUID = 1L;
    Buddy buddy;
    boolean isFound;

    public Response(Buddy buddy, boolean isFound) {
        this.buddy = buddy;
        this.isFound = isFound;
    }

    public Buddy getBuddy() {
        return buddy;
    }

    public void setBuddy(Buddy buddy) {
        this.buddy = buddy;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }
}
