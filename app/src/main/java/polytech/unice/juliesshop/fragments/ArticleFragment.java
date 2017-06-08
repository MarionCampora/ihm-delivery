package polytech.unice.juliesshop.fragments;

import android.app.Fragment;
import java.util.List;

import polytech.unice.juliesshop.model.Product;

/**
 * Created by Marion on 08/06/2017.
 */

public class ArticleFragment extends Fragment {


    List produits;
    private Product product = new Product();

    public ArticleFragment() {
        produits = product.products();
    }



}
