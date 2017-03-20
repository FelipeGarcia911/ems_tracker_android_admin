package co.original.codigo.ems_tracker_admin.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Felipe Garcia on 19/03/2017 - 9:45 PM.
 */

public class MarkerObject {

    private double latitude;
    private double longitude;
    private String title;
    private Marker marker;
    private MarkerOptions markerOptions;

    public MarkerObject(double latitude, double longitude, String title) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        createMarkerOptions();
    }

    private void createMarkerOptions(){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.title(getTitle());
        markerOptions.position(new LatLng(getLatitude(),getLongitude()));
        setMarkerOptions(markerOptions);
    }

    public MarkerOptions getMarkerOptions() {
        return markerOptions;
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        this.markerOptions = markerOptions;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (marker != null){
            marker.setTitle(title);
        }
    }

    public boolean updateMarkerPosition(double latitude, double longitude){
        if (marker != null){
            marker.setPosition(new LatLng(latitude,longitude));
            return true;
        }else{
            return false;
        }
    }
}
