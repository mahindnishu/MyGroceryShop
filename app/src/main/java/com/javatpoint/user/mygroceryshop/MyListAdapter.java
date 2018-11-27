package com.javatpoint.user.mygroceryshop;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Model> arrayList;

    public MyListAdapter(MainActivity mainActivity, ArrayList<Model> arrayList) {
        context=mainActivity;
        this.arrayList=arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {


        final ViewHolder viewHolder = new ViewHolder();;
        if(convertView==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.listview_row,null);
        }

        viewHolder.imageView=convertView.findViewById(R.id.imageview);
        viewHolder.textView_product_name=convertView.findViewById(R.id.textview_name);
        viewHolder.textView_price=convertView.findViewById(R.id.textview_price);
        viewHolder.editText_qty=convertView.findViewById(R.id.edittext_qty);


        viewHolder.imageView.setImageResource(arrayList.get(position).getProduct_img());
        viewHolder.textView_product_name.setText(""+arrayList.get(position).getProduct_name());
        viewHolder.textView_price.setText("Price : "+arrayList.get(position).getProduct_price());

        viewHolder.editText_qty.setTag(position);

        if(arrayList.get(position).getQty()==0)
        {
            viewHolder.editText_qty.setText("");
        }
        else
            viewHolder.editText_qty.setText(""+arrayList.get(position).getQty());



        viewHolder.editText_qty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("yes");
                int pos= (int) viewHolder.editText_qty.getTag();
                if(viewHolder.editText_qty.getText().toString().length()>0) {
                    arrayList.get(pos).setQty(Integer.parseInt(viewHolder.editText_qty.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView textView_product_name;
        TextView textView_price;
        EditText editText_qty;
    }
}
