package ir.adicom.app.soccerapp.models;

import io.realm.RealmObject;

/**
 *
 * Created by adicom on 6/17/17.
 */

public class Continent extends RealmObject {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override

    public String toString() {
        return "[" + id + "," + name + "]";
    }
}
