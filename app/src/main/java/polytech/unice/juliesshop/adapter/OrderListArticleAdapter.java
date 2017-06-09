package polytech.unice.juliesshop.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import polytech.unice.juliesshop.R;
import polytech.unice.juliesshop.fragments.DayFragment;
import polytech.unice.juliesshop.fragments.OrdersFragment;
import polytech.unice.juliesshop.model.OrderProduct;
import polytech.unice.juliesshop.model.Product;

/**
 * @author Marion
 */

public class OrderListArticleAdapter extends ArrayAdapter {

    private FragmentManager fragment;
    private OrderProduct orderer;


    public OrderListArticleAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects, FragmentManager fragment) {
        super(context, 0, objects);
        this.fragment = fragment;
        orderer = new OrderProduct(context);

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final List orders = orderer.orderer();

        if (convertView == null && !orders.isEmpty()) {
            convertView = inflater.inflate(R.layout.my_order_layout, null);
        } else if (convertView == null && orders.isEmpty()) {
            convertView = inflater.inflate(R.layout.home_fragment, null);
        }


        final Product product = (Product) orders.get(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_order);
        imageView.setImageResource(product.getPicture());

        TextView titleText = (TextView) convertView.findViewById(R.id.title_order);
        titleText.setText(product.getName());

        TextView categoryText = (TextView) convertView.findViewById(R.id.price_order);
        categoryText.setText(product.getPrice());

        final Button unorder_button = (Button) convertView.findViewById(R.id.unorder_button);
        final Button get_button = (Button) convertView.findViewById(R.id.get_button);

        if (product.getName().equals("")) {
            get_button.setVisibility(View.INVISIBLE);
            unorder_button.setVisibility(View.INVISIBLE);
        }

        unorder_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                unorder_button.setBackgroundColor(Color.parseColor("#4a2612"));
                orderer.getEditorOrder().remove(product.getName()).commit();
                fragment.beginTransaction().replace(R.id.content_frame, new OrdersFragment()).commit();
            }
        });

        get_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_button.setBackgroundColor(Color.parseColor("#4a2612"));
                fragment.beginTransaction().replace(R.id.content_frame, new DayFragment()).commit();
            }
        });


        return convertView;
    }
}
