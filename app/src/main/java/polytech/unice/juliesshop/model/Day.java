package polytech.unice.juliesshop.model;

/**
 * @author Marion
 */

public class Day {
    private String day;

    public Day(String day) {
        this.day = day;
    }

    public String[] nextD(String day) {
        String[] jours = {};
        switch (day) {
            case "Lundi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:19,20,40,55,5&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Mardi";
                jours[2] = "Samedi";
                break;
            case "Mardi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:10,40,20,25,75&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Mercredi";
                jours[2] = "Lundi";
                break;
            case "Mercredi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:80,60,20,25,72&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Jeudi";
                jours[2] = "Mardi";
                break;
            case "Jeudi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:40,60,26,25,32&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Vendredi";
                jours[2] = "Mercredi";
                break;
            case "Vendredi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:70,60,10,25,62&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Samedi";
                jours[2] = "Jeudi";
                break;
            case "Samedi":
                jours[0] = "http://chart.apis.google.com/chart?cht=bvs&chs=150x200&chd=t:49,70,0,0,0&chl= 8-10 | 10-12 | 12-14 | 14-16 | 16-18 &chco=00A5C6";
                jours[1] = "Vendredi";
                jours[2] = "Lundi";
                break;
        }
        return jours;
    }


}
