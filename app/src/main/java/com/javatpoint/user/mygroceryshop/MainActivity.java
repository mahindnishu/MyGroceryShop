package com.javatpoint.user.mygroceryshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView listview;
    Button button_calculate_bill;

    MyListAdapter myListAdapter;
    Model model;
    ArrayList<Model> arrayList=new ArrayList<>();

    String[] product;
    int[] img;
    int[] price;
    int qty=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=findViewById(R.id.listview);

        product=getResources().getStringArray(R.array.product);
        price=getResources().getIntArray(R.array.price);
        img=getResources().getIntArray(R.array.img);

        for(int i=0;i<product.length;i++)
        {
            model=new Model(product[i],price[i],img[i],qty);
            arrayList.add(model);
        }
        myListAdapter=new MyListAdapter(MainActivity.this,arrayList);

        listview.setAdapter(myListAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Clicked "+i,Toast.LENGTH_LONG).show();
            }
        });

        button_calculate_bill=findViewById(R.id.button_calc_bill);
        button_calculate_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res=0;
                for(int i=0;i<arrayList.size();i++)
                {
                    res=res+(arrayList.get(i).getQty()*price[i]);
                }
                Toast.makeText(MainActivity.this,"Your Bill is : "+res, Toast.LENGTH_LONG).show();
            }
        });



    }
}
