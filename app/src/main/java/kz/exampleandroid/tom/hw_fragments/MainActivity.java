package kz.exampleandroid.tom.hw_fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kz.exampleandroid.tom.hw_fragments.adapters.ProductsRecyclerAdapter;
import kz.exampleandroid.tom.hw_fragments.models.Product;



public class MainActivity extends AppCompatActivity {
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          initialProducts();




        Fragment itemDescFragment =  getSupportFragmentManager().findFragmentById(R.id.fragment_item_description);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fp_products_rv);

        ProductsRecyclerAdapter productsRecyclerAdapter =
                new ProductsRecyclerAdapter(products, getApplicationContext(), itemDescFragment);
        recyclerView.setAdapter(productsRecyclerAdapter);
    }

    private void initialProducts() {
        products = new ArrayList<>();
        products.add(new Product("prod_1", "В RxJava 2 также появился новый метод subscribeWith, который похож на subscribe из RxJava 1. Он возвращает Disposable.", 100, 1));
        products.add(new Product("prod_2", "Вместо этого есть возможность использовать DisposableObserver, который автоматически обработает этот четвёртый метод, так что вам достаточно будет позаботиться лишь об уведомлениях от самого ", 200, 2));
        products.add(new Product("prod_3", "По аналогии с составной подпиской из RxJava есть и составной Disposable: вы можете подписаться на несколько источников, взять возвращаемые Disposable, добавить их в CompositeDisposable и одновременно отписаться от всех потоков.", 300, 3));
    }

    private void initialFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.ma_container, new ProductFragment());
        transaction.add(R.id.ma_container, new ItemDescriptionFragent());
        transaction.commit();
    }


}
