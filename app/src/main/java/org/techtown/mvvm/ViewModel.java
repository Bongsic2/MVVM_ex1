package org.techtown.mvvm;

import androidx.databinding.BaseObservable;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseObservable {
    private Database database;
    private List<Person> items = new ArrayList<>();
    private String winner;

    public ViewModel(Database database) {
        this.database = database;
        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                winner = null;
                winner = database.getWinner();
                notifyChange();
            }
        });
    }

    public void getUser() {
        database.getUser();

    }

    public String getWinner() {
        return winner;
    }
}
