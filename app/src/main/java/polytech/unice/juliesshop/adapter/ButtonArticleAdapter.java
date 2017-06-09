package polytech.unice.juliesshop.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
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

import java.util.List;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.fragments.OrdersFragment;
import polytech.unice.juliesshop.fragments.ProductsFragment;
import polytech.unice.juliesshop.model.OrderProduct;
import polytech.unice.juliesshop.model.Product;

import static android.view.View.INVISIBLE;

/**
 * @author Marion
 */

public class ButtonArticleAdapter extends ArrayAdapter {

    private OrderProduct prod ;
    private FragmentManager fragment;

    public ButtonArticleAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects, FragmentManager fragment) {
        super(context, 0, objects);
        prod = new OrderProduct(context);
        this.fragment = fragment;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.my_layout, null);
        }
        //final Product product = (Product) getItem(position);
        final Product product = (Product) prod.liked().get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image34);
        imageView.setImageResource(product.getPicture());
        if (product.isNews()) {
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.logo34);
            imageView1.setVisibility(View.VISIBLE);
        } else {
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.logo34);
            imageView1.setVisibility(INVISIBLE);
        }

        TextView titleText = (TextView) convertView.findViewById(R.id.title34);
        titleText.setText(product.getName());

        TextView categoryText = (TextView) convertView.findViewById(R.id.price34);
        categoryText.setText(product.getPrice());

        final Button like_button = (Button) convertView.findViewById(R.id.like_button);
        final Button unlike_button = (Button) convertView.findViewById(R.id.unlike_button);
        final Button order_button = (Button) convertView.findViewById(R.id.order_button);
        unlike_button.setVisibility(INVISIBLE);

        like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                like_button.setBackgroundColor(Color.parseColor("#4a2612"));
                unlike_button.setVisibility(INVISIBLE);
                prod.getEditorLike().putString(product.getName(),product.getName()).commit();
                fragment.beginTransaction().replace(R.id.content_frame, new ProductsFragment()).commit();
            }
        });
        unlike_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unlike_button.setBackgroundColor(Color.parseColor("#4a2612"));
                like_button.setVisibility(INVISIBLE);
                prod.getEditorUnlike().putString(product.getName(),product.getName()).commit();
                fragment.beginTransaction().replace(R.id.content_frame, new ProductsFragment()).commit();

            }
        });
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_button.setBackgroundColor(Color.parseColor("#4a2612"));
                prod.getEditorOrder().putString(product.getName(),product.getName()).commit();
                fragment.beginTransaction().replace(R.id.content_frame, new OrdersFragment()).commit();
            }
        });
        return convertView;

    }

}