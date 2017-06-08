package polytech.unice.juliesshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.model.Event;


/**
 * @author Marion
 */

public class EventListAdapter extends ArrayAdapter {

    private List<Event> events;
    private Event event = new Event();
    private Intent intent;

    public EventListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, 0, objects);
        events = event.events();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.my_event_layout, null);
        }
        Event event = (Event) getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_event);
        imageView.setImageResource(event.getPicture());
        TextView titleText = (TextView) convertView.findViewById(R.id.title_event);
        titleText.setText(event.getName());
        TextView date = (TextView) convertView.findViewById(R.id.date);
        date.setText(event.getDate());
        final Button add_button = (Button) convertView.findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_button.setBackgroundColor(Color.parseColor("#4a2612"));
                Event event = new Event();
                Event newEvent = event.events().get(position);
                Intent newI = newIntent(newEvent);
                getContext().startActivity(newI);
            }
        });

        return convertView;
    }

    public Intent newIntent(Event newEvent) {
        intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, newEvent.getBeginTime().getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, newEvent.getEndTime().getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, newEvent.getName())
                .putExtra(CalendarContract.Events.DESCRIPTION, newEvent.getDescription())
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
        return intent;
    }
}
