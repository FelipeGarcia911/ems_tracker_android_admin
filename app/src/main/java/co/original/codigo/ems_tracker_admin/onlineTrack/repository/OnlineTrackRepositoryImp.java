package co.original.codigo.ems_tracker_admin.onlineTrack.repository;

import co.original.codigo.ems_tracker_admin.helpers.SocketEvents;
import co.original.codigo.ems_tracker_admin.helpers.socket_io.SocketConnection;
import co.original.codigo.ems_tracker_admin.models.SocketMessageObject;
import co.original.codigo.ems_tracker_admin.onlineTrack.interactor.OnlineTrackInteractor;
import co.original.codigo.ems_tracker_admin.onlineTrack.interactor.OnlineTrackInteractorImp;

public class OnlineTrackRepositoryImp implements OnlineTrackRepository {

    private OnlineTrackInteractor interactor;
    private SocketConnection socketConnection;

    public OnlineTrackRepositoryImp(OnlineTrackInteractorImp interactor) {
        this.interactor = interactor;
        this.socketConnection = SocketConnection.getInstance();
    }

    @Override
    public void getVehicleData() {
        SocketMessageObject messageObject = new SocketMessageObject();
        messageObject.setMethod(SocketEvents.GET_VEHICLES_DATA_REQUEST);
        socketConnection.emitSocketMessage(messageObject.getMethod(),messageObject.serializeObject());
    }

    private void onGetVehicleDataSuccess(String data){
        interactor.onGetVehiclesDataSuccess();
    }

    private void onGetVehicleDataFailure(String errorMsg){
        interactor.onGetVehiclesDataFailure();
    }
}
