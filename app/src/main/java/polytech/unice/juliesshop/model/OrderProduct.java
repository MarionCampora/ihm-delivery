package polytech.unice.juliesshop.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        for (Map.Entry<String, String> nam : names.entrySet()) {
            Product prod = product.tri(nam.getKey());
            orderer.add(prod);
        }
        return orderer;
    }

    public List<Product> liked() {
        Map<String, String> names = (Map<String, String>) preferencesLike.getAll();
        for (int i = 0; i < names.size(); i++) {
            Product prod = product.tri(String.valueOf(names.values()));
            like.add(prod);
        }
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
