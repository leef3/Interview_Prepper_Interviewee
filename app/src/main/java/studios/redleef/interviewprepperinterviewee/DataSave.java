package studios.redleef.interviewprepperinterviewee;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Fred Lee on 9/25/2015.
 */
public class DataSave {

    //SaveName = Title, SaveString = Final SaveString
    String saveName;
    String saveString;
    Context context;
    ArrayList<?> dataList;

    //Name the lists like RecipeDataSave or ScheduleDataSave
    public DataSave(String saveName, String saveString, Context context)
    {
        //These will never change after instantiation so good for constructor
        this.saveName = saveName;
        this.context = context;
        this.saveString = saveString;
    }

    public void SetList(ArrayList<?> toSet)
    {
        dataList = toSet;
    }

    public void Save()
    {
        SharedPreferences.Editor settings = context.getSharedPreferences("pref",0).edit();
        String data = new Gson().toJson(dataList);
        System.out.println("DataSaveClass - Saving Data:  " + data);
        settings.putString(saveString, data);
        settings.commit();
    }

    public void SetAndSaveList(ArrayList<?> toSet)
    {
        SetList(toSet);
        Save();
    }


    //Right now getting data is still CLASS SPECIFIC
    /*
    public ArrayList<?> GetList(Type CustomObject)
    {
        ArrayList<?> toReturn = new ArrayList<>();

        SharedPreferences settings = context.getSharedPreferences("pref",0);
        String objectData = settings.getString(saveString, "");
        if (!objectData.equals("")) {
            System.out.println("Object Data: " + objectData);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<?>>() {
            }.getType();
            JsonArray jArray = new JsonParser().parse(objectData).getAsJsonArray();
            for (JsonElement e : jArray) {
                CustomObject c = gson.fromJson(e, CustomObject.class);
                recipes.add(c);
            }
        }
    }
    */

}
