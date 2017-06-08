package polytech.unice.juliesshop.fragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import polytech.unice.juliesshop.adapter.ButtonArticleAdapter;
import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.model.Product;

/**
 * @author Marion
 */

public class HomeFragment extends ArticleFragment {

    private View myView;
    private List produits;
    private Product product = new Product();

    public HomeFragment() {
        produits = product.products();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home_fragment, container, false);
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
