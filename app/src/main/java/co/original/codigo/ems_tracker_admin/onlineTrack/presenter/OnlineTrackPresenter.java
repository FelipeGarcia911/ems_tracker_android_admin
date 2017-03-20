package co.original.codigo.ems_tracker_admin.onlineTrack.presenter;

public interface OnlineTrackPresenter {

    void onMapReady();
    void onUpdateMapButtonClick();

    // Fragment Methods
    void onCreate();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();

}
