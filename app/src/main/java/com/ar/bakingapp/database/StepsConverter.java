package com.ar.bakingapp.database;

import android.arch.persistence.room.TypeConverter;

import com.ar.bakingapp.network.model.StepsItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StepsConverter {
    @TypeConverter
    public String fromList(List<StepsItem> items) {
        if (items == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<StepsItem>>() {
        }.getType();
        return gson.toJson(items, type);
    }

    @TypeConverter
    public List<StepsItem> toList(String itemString) {
        if (itemString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<StepsItem>>() {
        }.getType();
        return gson.fromJson(itemString, type);
    }
}
