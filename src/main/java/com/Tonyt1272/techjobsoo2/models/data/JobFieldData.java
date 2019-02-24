package com.Tonyt1272.techjobsoo2.models.data;


import com.Tonyt1272.techjobsoo2.models.JobField;

import java.util.ArrayList;

//import org.launchcode.models.JobField;

/**
 * Created by LaunchCode
 */
public class JobFieldData<T extends JobField> {

    private ArrayList<T> allFields = new ArrayList<>();

    public ArrayList<T> findAll() {
        return allFields;
    }

    public T findById(int id) {
        for (T item : allFields) {
            if (item.getId() == id)
                return item;
        }

        return null;
    }

    public void add(T item) {
        allFields.add(item);
    }

    T findByValue(String value) {
        for (T item : allFields) {
            if (item.contains(value))
                return item;
        }

        return null;
    }

}

