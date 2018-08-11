package kz.exampleandroid.tom.hw_fragments.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import kz.exampleandroid.tom.hw_fragments.ItemDescriptionFragent;
import kz.exampleandroid.tom.hw_fragments.R;

import java.util.List;

import kz.exampleandroid.tom.hw_fragments.models.Product;

public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder>{

    List<Product> products;
    Context context;
    Fragment itemDescriptionFragent;

    public ProductsRecyclerAdapter(@NonNull List<Product> productList, Context context, Fragment itemFragment) {
        products = productList;
        this.context = context;
        itemDescriptionFragent = itemFragment;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ProductViewHolder(layoutInflater.inflate(R.layout.products, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {
       Product product = products.get(i);
       productViewHolder.name.setText(product.getName());
       productViewHolder.name.setTag(product.getId());

       productViewHolder.name.setOnClickListener(view -> {
           ((TextView)itemDescriptionFragent.getView().findViewById(R.id.item_name_tv)).setText(product.getName());
           ((TextView)itemDescriptionFragent.getView().findViewById(R.id.item_description_tv)).setText(product.getDescription());
           ((TextView)itemDescriptionFragent.getView().findViewById(R.id.item_price_tv)).setText("Цена: " + String.valueOf(product.getPrice()));
       });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.prod_name_tv);
        }
    }


}
