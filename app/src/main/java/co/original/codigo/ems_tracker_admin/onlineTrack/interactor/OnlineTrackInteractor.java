package co.original.codigo.ems_tracker_admin.onlineTrack.interactor;

public interface OnlineTrackInteractor {

    //Callbacks Methods
    void onGetVehiclesDataSuccess();
    void onGetVehiclesDataFailure();

    // Fragment Methods
    void onCreate();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
