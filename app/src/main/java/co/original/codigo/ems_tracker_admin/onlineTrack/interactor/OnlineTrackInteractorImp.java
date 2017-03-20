package co.original.codigo.ems_tracker_admin.onlineTrack.interactor;

import android.os.Handler;

import co.original.codigo.ems_tracker_admin.helpers.Constants;
import co.original.codigo.ems_tracker_admin.onlineTrack.repository.OnlineTrackRepository;
import co.original.codigo.ems_tracker_admin.onlineTrack.repository.OnlineTrackRepositoryImp;

public class OnlineTrackInteractorImp implements OnlineTrackInteractor {

    private Handler handler;
    private OnlineTrackRepository repository;

    public OnlineTrackInteractorImp() {
        this.handler = new Handler();
        this.repository = new OnlineTrackRepositoryImp(this);
    }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            repository.getVehicleData();
            handler.postDelayed(runnableCode, Constants.UPDATE_ONLINE_INTERVAL);
        }
    };

    private void startUpdateCycle(){
        if (handler == null){
            handler = new Handler();
        }else{
            handler.removeCallbacks(runnableCode);
        }
        handler.post(runnableCode);
    }

    private void stopUpdateCycle(){
        if (handler != null){
            handler.removeCallbacks(runnableCode);
        }
    }

    @Override
    public void onResume() {
        startUpdateCycle();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {
        stopUpdateCycle();
    }

    @Override
    public void onDestroy() {
        stopUpdateCycle();
    }

    @Override
    public void onCreate() {
        startUpdateCycle();
    }

    @Override
    public void onGetVehiclesDataSuccess() {

    }

    @Override
    public void onGetVehiclesDataFailure() {

    }
}
