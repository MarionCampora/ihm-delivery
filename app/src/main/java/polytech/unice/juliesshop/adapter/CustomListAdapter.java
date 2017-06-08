package polytech.unice.juliesshop.adapter;

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
import polytech.unice.juliesshop.model.Product;

/**
 * @author Marion
 */

public class CustomListAdapter extends ArrayAdapter {

    public CustomListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate(R.layout.my_layout,null);
        }
        Product product = (Product) getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image34);
        imageView.setImageResource(product.getPicture());
        if (product.isNews()){
            ImageView imageView1 = (ImageView)convertView.findViewById(R.id.logo34);
            imageView1.setVisibility(View.VISIBLE);
        }
        else {
            ImageView imageView1 = (ImageView)convertView.findViewById(R.id.logo34);
            imageView1.setVisibility(View.INVISIBLE);
        }
        TextView titleText = (TextView)convertView.findViewById(R.id.title34);
        titleText.setText(product.getName());

        TextView categoryText = (TextView)convertView.findViewById(R.id.price34);
        categoryText.setText( product.getPrice());

        /*final Button like_button = (Button) convertView.findViewById(R.id.like_button);
        final Button unlike_button = (Button) convertView.findViewById(R.id.unlike_button);
        final Button order_button = (Button) convertView.findViewById(R.id.order_button);
        like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product hp = (Product) produits.get(0);
                hp.setLiked(1);
                like_button.setBackgroundColor(Color.parseColor("#4a2612"));
            }
        });
        unlike_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product hp = (Product) produits.get(0);
                hp.setLiked(2);
                unlike_button.setBackgroundColor(Color.parseColor("#4a2612"));
            }
        });
        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product hp = (Product) produits.get(0);
                hp.setLiked(2);
                order_button.setBackgroundColor(Color.parseColor("#4a2612"));
        */
        return convertView;
    }
}
