package polytech.unice.juliesshop.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.adapter.EventListAdapter;
import polytech.unice.juliesshop.model.Event;

/**
 * @author Marion
 */

public class EventsFragment extends Fragment {
    private List events;
    private Event event = new Event();
    private View myView;

    public EventsFragment() {
        events = event.events();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.events_fragment, container, false);
        GridView gridView = (GridView) myView.findViewById(R.id.gridView_event);
        EventListAdapter eventListAdapter = new EventListAdapter(myView.getContext(), android.R.layout.simple_list_item_1, events);
        gridView.setAdapter(eventListAdapter);
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
