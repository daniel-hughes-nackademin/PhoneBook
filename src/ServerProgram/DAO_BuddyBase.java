package ServerProgram;

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


    String getBuddyInfo(String input){
        StringBuilder buddyInfo = new StringBuilder();
        input.trim();

        for (Buddy buddy: buddyList) {
            if(buddy.name.equalsIgnoreCase(input)){
                buddyInfo.append("Buddy info:,");
                buddyInfo.append(buddy.name + ',');
                buddyInfo.append(buddy.phoneNr + ',');
                buddyInfo.append(buddy.dateOfBirth + ',');
                buddyInfo.append(buddy.email);
                return buddyInfo.toString();
            }
        }
        return "Buddy \"" + input + "\" is not found in the system!";


    }
}
