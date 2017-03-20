package co.original.codigo.ems_tracker_admin.onlineTrack.presenter;

import co.original.codigo.ems_tracker_admin.onlineTrack.interactor.OnlineTrackInteractor;
import co.original.codigo.ems_tracker_admin.onlineTrack.interactor.OnlineTrackInteractorImp;
import co.original.codigo.ems_tracker_admin.onlineTrack.view.OnlineTrackFragment;

public class OnlineTrackPresenterImp implements OnlineTrackPresenter {

    private OnlineTrackFragment view;
    private OnlineTrackInteractor interactor;

    public OnlineTrackPresenterImp(OnlineTrackFragment view) {
        this.view = view;
        this.interactor = new OnlineTrackInteractorImp();
    }

    @Override
    public void onMapReady() {

    }

    @Override
    public void onUpdateMapButtonClick() {

    }

    @Override
    public void onResume() {
        interactor.onResume();
    }

    @Override
    public void onPause() {
        interactor.onPause();
    }

    @Override
    public void onStop() {
        interactor.onStop();
    }

    @Override
    public void onDestroy() {
        interactor.onDestroy();
    }

    @Override
    public void onCreate() {
        interactor.onCreate();
    }

}
