package ServerProgram;

import Resources.Buddy;
import Resources.Intro;
import Resources.Response;

public class Protocol {

    enum State {
        INITIALIZATION,
        AWAITING_RESPONSE
    }

    State state = State.INITIALIZATION;
    DAO_BuddyBase buddyBase = new DAO_BuddyBase();


    public Object getObject(String inputLine) {
        if (state == State.INITIALIZATION) {
            state = State.AWAITING_RESPONSE;
            return new Intro("Connection established with server");
        } else {
            Buddy buddy = buddyBase.getBuddy(inputLine);
            Response outputResponse;
            if (buddy == null) {
                outputResponse = new Response(null, false);
            } else {
                outputResponse = new Response(buddy, true);
            }
            return outputResponse;
        }
    }
}
