package ir.adicom.app.soccerapp.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *
 * Created by adicom on 6/17/17.
 */

public class Continent extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;

    public Continent() {}

    public Continent(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
