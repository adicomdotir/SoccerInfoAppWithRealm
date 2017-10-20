package ir.adicom.app.soccerapp.presenters;

import android.content.Context;
import android.support.annotation.NonNull;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import ir.adicom.app.soccerapp.models.Continent;
import ir.adicom.app.soccerapp.views.IView;

/**
 *
 * Created by adicom on 6/23/17.
 */

public class Presenter  implements IPresenter {

    @NonNull
    private final IView mView;

    public Presenter(@NonNull final IView view, @NonNull Context context) {
        mView = view;
    }

    @Override
    public void bind() {
    }

    @Override
    public void unBind() {
    }

    private void setGreeting(@NonNull final String greeting) {
        mView.setGreeting(greeting);
    }
}