package polytech.unice.juliesshop.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.zip.Inflater;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.model.Day;
import polytech.unice.juliesshop.model.OrderProduct;

import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static polytech.unice.juliesshop.R.id.textView;

/**
 * @author Marion
 */

public class DayFragment extends Fragment {
    private Calendar calendar;
    private int day;
    private View myView;

    public DayFragment() {
        calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_WEEK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch (day) {
            case MONDAY:
            case SUNDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Lundi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:19,20,40,55,5&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6"
                        );
                break;
            case THURSDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Mardi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:10,40,20,25,75&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6");
                break;
            case WEDNESDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Mercredi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:80,60,20,25,72&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6");
                break;
            case TUESDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Jeudi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:40,60,26,25,32&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6");
                break;
            case FRIDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Vendredi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:70,60,10,25,62&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6");
                break;
            case SATURDAY:
                myView = inflater.inflate(R.layout.day_layout, container, false);
                createView("Samedi",
                        "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:49,70,0,0,0&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6");
                break;
        }

        return myView;
    }

    private void createView(String day, String Url){
        WebView webView = (WebView) myView.findViewById(R.id.web_view);
        webView.loadUrl(Url);
        TextView textView = (TextView) myView.findViewById(R.id.day);
        textView.setText(day);
        final Button ok_button = (Button) myView.findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok_button.setBackgroundColor(Color.parseColor("#4a2612"));
                FragmentManager fragmentManager = getActivity().getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, new OrdersFragment()).commit();
            }
        });

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
