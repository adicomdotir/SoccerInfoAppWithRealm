package ir.adicom.app.soccerapp.views;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ir.adicom.app.soccerapp.R;
import ir.adicom.app.soccerapp.models.Continent;
import ir.adicom.app.soccerapp.presenters.IPresenter;
import ir.adicom.app.soccerapp.presenters.Presenter;

public class MainActivity extends AppCompatActivity implements IView {

    private static final String LOG_TAG = "TAG";
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        // Realm.init(this);
        final RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded().build();
//        Realm.setDefaultConfiguration(configuration);
        Realm realm = Realm.getInstance(configuration);

        showStatus("Perform basic Create/Read/Update/Delete (CRUD) operations...");

        // All writes must be wrapped in a transaction to facilitate safe multi threading
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                // Add a continent
//                Continent continent = realm.createObject(Continent.class);
//                continent.setId(20);
//                continent.setName("Asia");
//
//            }
//        });
//
        Continent c01 = new Continent(55, "Eroupe");
        realm.beginTransaction();
        realm.copyToRealm(c01);
        realm.commitTransaction();

        // Find the first continent (no query conditions) and read a field
        final Continent continent = realm.where(Continent.class).findFirst();
        showStatus(continent.toString());

        // Update continent in a transaction
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                continent.setName("Africa");
                showStatus(continent.toString());
            }
        });

        // Delete all continents
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(Continent.class);
            }
        });

        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/splash.ttf");
        TextView tvHeader = (TextView) findViewById(R.id.tvHeader);
        if (tvHeader != null) tvHeader.setTypeface(font);
        IPresenter presenter = new Presenter(this, this);
    }

    @Override
    public void setGreeting(@NonNull String greeting) {
        Log.e(LOG_TAG, greeting);
    }

    private void showStatus(String txt) {
        Log.i(TAG, txt);
    }
}
