package com.pointofsale.data;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesService {

    private static final String PREFS_NAME = "goldpocket";
    private static PreferencesService mSingleton = new PreferencesService();
    private static Context mContext;

    public static final String Login_Status = "Login_Status";
    public static final String USERSTATUS = "USERSTATUS";
    public static final String Main_service = "Main_service";

    private PreferencesService() {

    }

    public static PreferencesService instance() {
        return mSingleton;
    }

    public static void init(Context context) {

        mContext = context;
    }

    public SharedPreferences getPrefs() {
        return mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void ClearPreference() {
        SharedPreferences settings = getPrefs();
        settings.edit().clear().commit();
    }

    public void saveStatus(String status){
    SharedPreferences.Editor editor = getPrefs().edit();
    editor.putString("status", status);
    editor.commit();
    }

    public String getStatus(){
        return getPrefs().getString("status", "");
    }

    public void saveLogin_Status(String login_Status){
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(Login_Status, login_Status);
        editor.commit();
    }

    public String getLogin_Status(){
        return getPrefs().getString(Login_Status, "");
    }

    public void saveMemberNo(String member){
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("member", member);
        editor.commit();
    }

    public String getMemberNo(){
        return getPrefs().getString("member", "");
    }

    public void Setserverotp(String member){
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("otp", member);
        editor.commit();
    }

    public String getServerOtp(){
        return getPrefs().getString("otp", "");
    }

    public void saveBalance(String member){
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("balance", member);
        editor.commit();
    }

    public String getBalance(){
        return getPrefs().getString("balance","0");
    }

    public void saveResponse(String response){
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("response", response);
        editor.commit();
    }

    public String getResponse(){
        return getPrefs().getString("response","");
    }

//    public void saveUserDetails(ArrayList<UserDetailModel> serviceTypes) {
//        SharedPreferences.Editor editor = getPrefs().edit();
//        Gson gson = new Gson();
//        String jsonFavorites = gson.toJson(serviceTypes);
//        editor.putString(USERSTATUS, jsonFavorites);
//        editor.commit();
//    }

//    public ArrayList<UserDetailModel>  getUserDetails() {
//        List<UserDetailModel> favorites;
//        if (getPrefs().contains(USERSTATUS)) {
//            String jsonFavorites = getPrefs().getString(USERSTATUS, null);
//            Gson gson = new Gson();
//            UserDetailModel[] favoriteItems = gson.fromJson(jsonFavorites,
//                    UserDetailModel[].class);
//
//            favorites = Arrays.asList(favoriteItems);
//            favorites = new ArrayList<UserDetailModel>(favorites);
//        } else
//            return null;
//
//        return (ArrayList<UserDetailModel>) favorites;
//    }
//
//    public void savePanCard(ArrayList<UserDetailModel> serviceTypes) {
//        SharedPreferences.Editor editor = getPrefs().edit();
//        Gson gson = new Gson();
//        String jsonFavorites = gson.toJson(serviceTypes);
//        editor.putString("pan", jsonFavorites);
//        editor.commit();
//    }
//
//    public ArrayList<UserDetailModel>  getPanCard() {
//        List<UserDetailModel> favorites;
//        if (getPrefs().contains("pan")) {
//            String jsonFavorites = getPrefs().getString("pan", null);
//            Gson gson = new Gson();
//            UserDetailModel[] favoriteItems = gson.fromJson(jsonFavorites,
//                    UserDetailModel[].class);
//
//            favorites = Arrays.asList(favoriteItems);
//            favorites = new ArrayList<UserDetailModel>(favorites);
//        } else
//            return null;
//
//        return (ArrayList<UserDetailModel>) favorites;
//    }
//
//    public void saveAdharCard(ArrayList<UserDetailModel> serviceTypes) {
//        SharedPreferences.Editor editor = getPrefs().edit();
//        Gson gson = new Gson();
//        String jsonFavorites = gson.toJson(serviceTypes);
//        editor.putString("adhar", jsonFavorites);
//        editor.commit();
//    }
//
//    public ArrayList<UserDetailModel>  getAdharCard() {
//        List<UserDetailModel> favorites;
//        if (getPrefs().contains("adhar")) {
//            String jsonFavorites = getPrefs().getString("adhar", null);
//            Gson gson = new Gson();
//            UserDetailModel[] favoriteItems = gson.fromJson(jsonFavorites,
//                    UserDetailModel[].class);
//
//            favorites = Arrays.asList(favoriteItems);
//            favorites = new ArrayList<UserDetailModel>(favorites);
//        } else
//            return null;
//
//        return (ArrayList<UserDetailModel>) favorites;
//    }

    public void saveTranscaton(String transaction) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("transaction", transaction);
        editor.commit();

    }

    public String getTransaction(){
        return getPrefs().getString("transaction","");
    }

    public void saveVerification(String verify) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("verify", verify);
        editor.commit();
    }

    public String getVerification(){
        return getPrefs().getString("verify","");
    }
}