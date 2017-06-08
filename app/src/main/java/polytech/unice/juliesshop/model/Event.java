package polytech.unice.juliesshop.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import polytech.unice.juliesshop.R;

/**
 * @author Marion
 */

public class Event {

    private String name;
    private Calendar beginTime;
    private Calendar endTime;
    private int picture;
    List events = new ArrayList();
    private String description;
    private String date;

    public Event() {

    }

    public Event(String name, int picture, Calendar beginTime, Calendar endTime, String description, String date) {
        this.name = name;
        this.picture = picture;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getBeginTime() {
        return beginTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public String getDate() {
        return date;
    }

    public List<Event> events(){
        Calendar beginTimeManga = Calendar.getInstance();
        beginTimeManga.set(2017, 4, 19, 7, 30);
        Calendar endTimeManga = Calendar.getInstance();
        endTimeManga.set(2017, 4, 19, 19, 30);
        Event manga = new Event("Mang'azur 2017", R.drawable.manga, beginTimeManga,endTimeManga, "Mang'azur 2017 à Saint Raphaël.", "Le 19 avril 2017 de 7h30 à 19h30.");
        Calendar beginTimeEscape = Calendar.getInstance();
        beginTimeEscape.set(2017, 6, 13, 10, 30);
        Calendar endTimeEscape = Calendar.getInstance();
        endTimeEscape.set(2017, 6, 13, 11, 30);
        Event escape = new Event("Escape game", R.drawable.escape, beginTimeEscape, endTimeEscape, "Sortez de la pièce avant le temps imparti.", "Le 13 juin 2017 de 10h30 à 11h30.");
        events.add(escape);
        events.add(manga);
        return events;
    }


}
