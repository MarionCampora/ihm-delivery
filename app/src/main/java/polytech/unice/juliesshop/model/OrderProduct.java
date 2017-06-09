package polytech.unice.juliesshop.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.ArraySet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Marion
 */

public class OrderProduct {

    private Context context;
    private SharedPreferences.Editor editorOrder, editorLike, editorUnlike;
    private SharedPreferences preferencesOrder, preferencesLike, preferencesUnlike;
    private Product product = new Product();
    private List orderer = new ArrayList();
    private List like = new ArrayList();

    public OrderProduct(Context context) {
        this.context = context;
        preferencesOrder = PreferenceManager.getDefaultSharedPreferences(context);
        preferencesLike = PreferenceManager.getDefaultSharedPreferences(context);
        preferencesUnlike = PreferenceManager.getDefaultSharedPreferences(context);
        editorOrder = preferencesOrder.edit();
        editorLike = preferencesLike.edit();
        editorUnlike = preferencesUnlike.edit();
    }

    public List<Product> orderer() {
        Map<String, String> names = (Map<String, String>) preferencesOrder.getAll();
        Set<Product> set = new ArraySet<>();
        for (Map.Entry<String, String> nam : names.entrySet()) {
            Product prod = product.tri(nam.getKey());
            if (!prod.getName().equals(""))
                set.add(prod);
        }
        if (set.isEmpty())
            orderer.add(new Product("","",0,0,false,false,4242));
        else
            orderer.addAll(set);
        return orderer;
    }

    public List<Product> liked() {
        Map<String, String> likes = (Map<String, String>) preferencesLike.getAll();
        Map<String,String> unlike = (Map<String, String>) preferencesUnlike.getAll();
        Set<Product> setl = new ArraySet<>();
        Set<Product> setu = new ArraySet<>();
        for (Map.Entry<String, String> nam : likes.entrySet()) {
            Product prod = product.tri(nam.getKey());
            if (!prod.getName().equals("")){
                setl.add(prod);
            }
        }
        for (Map.Entry<String, String > nam : unlike.entrySet()){
            Product prod = product.tri(nam.getKey());
            if (!prod.getName().equals("")){
                setu.add(prod);
            }
        }
        like.addAll(setl);
        like.addAll(product.products());
        return like;
    }

    public SharedPreferences.Editor getEditorOrder() {
        return editorOrder;
    }

    public SharedPreferences.Editor getEditorLike() {
        return editorLike;
    }

    public SharedPreferences.Editor getEditorUnlike() {
        return editorUnlike;
    }

    public SharedPreferences getPreferencesOrder() {
        return preferencesOrder;
    }

    public SharedPreferences getPreferencesLike() {
        return preferencesLike;
    }

    public SharedPreferences getPreferencesUnlike() {
        return preferencesUnlike;
    }
}
