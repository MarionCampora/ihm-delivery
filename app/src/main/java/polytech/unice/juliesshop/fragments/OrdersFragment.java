package polytech.unice.juliesshop.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.List;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.adapter.OrderListArticleAdapter;
import polytech.unice.juliesshop.model.Product;

/**
 * @author Marion
 */

public class OrdersFragment extends Fragment {

    View myView;
    private List produits;
    private Product product = new Product();


    public OrdersFragment() {
        produits = product.orderProducts();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.orders_fragment, container, false);
        GridView gridView = (GridView) myView.findViewById(R.id.gridView_order);
        FragmentManager current = getActivity().getFragmentManager();
        gridView.setAdapter(new OrderListArticleAdapter(myView.getContext(), android.R.layout.simple_list_item_1, produits, current));
        return myView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
