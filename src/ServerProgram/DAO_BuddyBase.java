package ServerProgram;

import Resources.Buddy;

import java.util.ArrayList;
import java.util.List;

public class DAO_BuddyBase {

    List<Buddy> buddyList;

    DAO_BuddyBase(){
        buddyList = new ArrayList<>();
        initializeBuddies();
    }

    void initializeBuddies(){
        buddyList.add(new Buddy("Kalle", "0708-123-123", "95-11-03", "kalleanka@gmail.com"));
        buddyList.add(new Buddy("Oscar", "0708-456-456", "92-03-15", "oscar123@gmail.com"));
        buddyList.add(new Buddy("Lisa", "0708-789-789", "87-02-27", "liiiiiiiiiisa007@hotmail.com"));
    }


    Buddy getBuddy(String input){
        input.trim();

        for (Buddy buddy: buddyList) {
            if(buddy.getName().equalsIgnoreCase(input)){

                return buddy;
            }
        }
        return null;


    }
}
