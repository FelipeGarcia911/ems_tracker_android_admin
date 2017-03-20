package co.original.codigo.ems_tracker_admin.trackHistory.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.original.codigo.ems_tracker_admin.R;

public class TrackHistoryFragment extends Fragment {

    public TrackHistoryFragment() {
        // Required empty public constructor
    }

    public static TrackHistoryFragment newInstance(String param1, String param2) {
        TrackHistoryFragment fragment = new TrackHistoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track_history_view, container, false);
    }



}
