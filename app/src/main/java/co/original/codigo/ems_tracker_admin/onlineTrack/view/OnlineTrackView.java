package co.original.codigo.ems_tracker_admin.onlineTrack.view;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public interface OnlineTrackView {

    Marker addMarkerToMap(MarkerOptions markerOptions);
    void centerMap(Double latitude, Double longitude, float mapZoom);
    void clearMap();

    void updateConnectionText(String string);
    void updateConnectionColor(String color);

}
