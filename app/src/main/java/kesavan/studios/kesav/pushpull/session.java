package kesavan.studios.kesav.pushpull;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kesav on 2017-04-16.
 */

public class session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public session(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean logggedin) {
        editor.putBoolean("loggedInmode", logggedin);
        editor.commit();
    }

    public boolean loggedin() {
        return prefs.getBoolean("loggedInmode", false);
    }
}
