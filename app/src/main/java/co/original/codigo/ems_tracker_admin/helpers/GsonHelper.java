package co.original.codigo.ems_tracker_admin.helpers;

import com.google.gson.Gson;

public class GsonHelper {
    private final Gson gson;

    public GsonHelper() {
        this.gson = new Gson();
    }

    public String serializeObject(Object object){
        return gson.toJson(object);
    }

}
