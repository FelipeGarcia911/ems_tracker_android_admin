package co.original.codigo.ems_tracker_admin.helpers.LocalStorage;

import android.util.Log;

import com.google.gson.Gson;

import co.original.codigo.ems_tracker_admin.models.UserObject;

public class UserLocalStorage {

    private static final String USER_KEY = "USER_KEY";
    private static final String USER_TIME = "USER_TIME";
    private static final String ANONYMOUS_USER_ID = "ANONYMOUS_USER_ID";

    private Gson gson;
    private SharedPreferencesHelper preferencesHelper;

    private static class SingletonHolder {
        private static final UserLocalStorage INSTANCE = new UserLocalStorage();
    }

    public static UserLocalStorage getInstance() {
        return UserLocalStorage.SingletonHolder.INSTANCE;
    }

    public void initialize(){
        this.gson = new Gson();
        this.preferencesHelper = SharedPreferencesHelper.getInstance();
    }

    public void setUser(UserObject userObject){
        String gsonString = gson.toJson(userObject);
        preferencesHelper.write(USER_KEY,gsonString);
        saveUserTime();
    }

    public UserObject getUser(){
        UserObject userObject;
        String jsonString = preferencesHelper.read(USER_KEY);
        if (jsonString == null || jsonString.isEmpty()){
            return null;
        }else{
            userObject = gson.fromJson(jsonString,UserObject.class);
            return userObject;
        }
    }

    public void deleteUser(){
        if (preferencesHelper != null) {
            preferencesHelper.remove(USER_KEY);
            preferencesHelper.remove(USER_TIME);
        }else{
            Log.e("UserLocalStorage","preferencesHelper null");
        }
    }

    private void saveUserTime(){
        long longTime = System.currentTimeMillis();
        String stringTime = String.valueOf(longTime);
        if (preferencesHelper != null) {
            preferencesHelper.write(USER_TIME, stringTime);
        }else{
            Log.e("UserLocalStorage","preferencesHelper null");
        }
    }

    public String getAnonymousUserId(){
        String anonymousUserId = preferencesHelper.read(ANONYMOUS_USER_ID);
        if (anonymousUserId == null || anonymousUserId.isEmpty()){
            return createAnonymousUserId();
        }else{
            return anonymousUserId;
        }
    }

    private String createAnonymousUserId(){
        long longTime = System.currentTimeMillis();
        String stringTime = String.valueOf(longTime);
        if (preferencesHelper != null) {
            preferencesHelper.write(ANONYMOUS_USER_ID, stringTime);
        }else{
            Log.e("UserLocalStorage","preferencesHelper null");
        }
        return stringTime;
    }

    private void deleteAnonymousUserId(){
        if (preferencesHelper != null) {
            preferencesHelper.remove(ANONYMOUS_USER_ID);
        }else{
            Log.e("UserLocalStorage","preferencesHelper null");
        }
    }

    public boolean isLogin(){
        return getUser() != null;
    }

}
