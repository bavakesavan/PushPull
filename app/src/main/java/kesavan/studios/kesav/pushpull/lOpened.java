package kesavan.studios.kesav.pushpull;


import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

/**
 * Created by User on 5/14/2018.
 */

@IgnoreExtraProperties
public class lOpened {

    private String UID;
    private @ServerTimestamp
    Date timestamp;

    public lOpened(String UID) {
        this.UID = UID;
    }

    public lOpened() {

    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
