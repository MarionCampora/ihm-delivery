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

public class NewsFragment extends ArticleFragment {

    View myView;
    List produits;
    private Product product = new Product();

    public NewsFragment() {
        produits = product.newsProduct();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.news_fragment, container, false);
        GridView listView = (GridView)  myView.findViewById(R.id.gridView);
        FragmentManager current = getActivity().getFragmentManager();
        listView.setAdapter(new ButtonArticleAdapter(myView.getContext(), android.R.layout.simple_list_item_1, produits, current));
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}
