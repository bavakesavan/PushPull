package kesavan.studios.kesav.pushpull;


import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

/**
 * Created by User on 5/14/2018.
 */

@IgnoreExtraProperties
public class Profile {

    private int Age;
    private String Gender;
    private int Height;
    private String Units;
    private int Weight;
    private String UID;
    private String Name;
    private String Email;
    private @ServerTimestamp
    Date timestamp;

    public Profile(int Age, String Gender, int Height, String Units, int Weight, String UID, String Name, String Email) {
        this.Age = Age;
        this.Gender = Gender;
        this.Height = Height;
        this.Units = Units;
        this.Weight = Weight;
        this.UID = UID;
    }

    public Profile() {

    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int Height) {
        this.Height = Height;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String Units) {
        this.Units = Units;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int Weight) {
        this.Weight = Weight;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
