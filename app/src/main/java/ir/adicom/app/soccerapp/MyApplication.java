package ir.adicom.app.soccerapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 *
 * Created by adicom on 10/20/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}
