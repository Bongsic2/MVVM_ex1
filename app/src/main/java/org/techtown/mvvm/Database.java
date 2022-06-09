package org.techtown.mvvm;

import java.util.ArrayList;


public class Database {
    private static Database instance;
    private ArrayList<Person> personList = new ArrayList<>();
    private String winner;
    private DatabaseListener databaseListener;

    private Database() {
        personList.add(new Person(0, "최OO"));
        personList.add(new Person(1, "김OO"));
        personList.add(new Person(2, "고OO"));
        personList.add(new Person(3, "문OO"));
        personList.add(new Person(4, "윤OO"));
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void getUser() {
        winner = personList.get((int) (Math.random() * 5)).getName();
        notifyChange();
    }

    private void notifyChange() {
        if (databaseListener != null) {
            databaseListener.onChanged();
        }
    }

    public void setOnDatabaseListener(DatabaseListener databaseListener) {
        this.databaseListener = databaseListener;
    }

    public String getWinner() {
        return winner;
    }

    public interface DatabaseListener {
        void onChanged();
    }
}