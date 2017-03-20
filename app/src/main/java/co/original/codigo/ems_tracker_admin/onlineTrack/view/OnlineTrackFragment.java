package co.original.codigo.ems_tracker_admin.onlineTrack.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import co.original.codigo.ems_tracker_admin.R;
import co.original.codigo.ems_tracker_admin.onlineTrack.presenter.OnlineTrackPresenter;
import co.original.codigo.ems_tracker_admin.onlineTrack.presenter.OnlineTrackPresenterImp;

public class OnlineTrackFragment extends Fragment implements OnMapReadyCallback, OnlineTrackView{

    private Unbinder unbinder;
    @BindView(R.id.updateButton) Button updateButton;
    @BindView(R.id.connectionStatusTV) TextView connectionStatusTV;

    private GoogleMap mMap;
    private OnlineTrackPresenter presenter;

    public OnlineTrackFragment() {
        this.presenter = new OnlineTrackPresenterImp(this);
    }

    public static OnlineTrackFragment newInstance() {
        OnlineTrackFragment fragment = new OnlineTrackFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_online_track, container, false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInterface();
    }

    private void initInterface(){
        presenter.onCreate();
        setupGoogleMap();
    }

    // Map Methods
    // ---------------------------------------------------------------------------------------------

    private void setupGoogleMap(){
        SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapOnlineTrack);
        mapFrag.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        presenter.onMapReady();
    }


    @Override
    public void centerMap(Double latitude, Double longitude, float mapZoom) {
        if(mMap != null){
            LatLng latLng = new LatLng(latitude, longitude);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,mapZoom));
        }
    }

    // Marker Methods
    // ---------------------------------------------------------------------------------------------

    @Override
    public void clearMap() {
        if (mMap != null){
            mMap.clear();
        }
    }

    @Override
    public void updateConnectionText(String string) {
        if (connectionStatusTV != null){
            connectionStatusTV.setText(string);
        }
    }

    @Override
    public void updateConnectionColor(String color) {
        if (connectionStatusTV != null){
            int colorValue;
            switch (color){
                case "RED":
                    colorValue = getResources().getColor(R.color.redConnStatus);
                    break;
                case "GREEN":
                    colorValue = getResources().getColor(R.color.redConnStatus);
                    break;
                case "GRAY":
                    colorValue = getResources().getColor(R.color.redConnStatus);
                    break;
                default:
                    colorValue = getResources().getColor(R.color.redConnStatus);
            }
            connectionStatusTV.setBackgroundColor(colorValue);
        }
    }

    @Override
    public Marker addMarkerToMap(MarkerOptions markerOptions) {
        return mMap.addMarker(markerOptions);
    }

    // Click Methods
    // ---------------------------------------------------------------------------------------------
    @OnClick(R.id.updateButton)
    void onUpdateMapButtonClick(){
        presenter.onUpdateMapButtonClick();
    }

    // Other Methods
    // ---------------------------------------------------------------------------------------------

    // Fragment Methods
    // ---------------------------------------------------------------------------------------------

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onStop() {
        presenter.onStop();
        super.onStop();
    }

    @Override
    public void onResume() {
        presenter.onResume();
        super.onResume();
    }
}
