package Resources;

import java.io.Serializable;

public class Buddy implements Serializable {

    static final long serialVersionUID = 42L;
    String name;
    String phoneNr;
    String dateOfBirth;
    String email;

    public Buddy(String name, String phoneNr, String dateOfBirth, String email) {
        this.name = name;
        this.phoneNr = phoneNr;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
