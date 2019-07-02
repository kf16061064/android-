package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.ListView;
import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment  {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        ListView listview=view.findViewById(R.id.rv);
        listview.setAdapter(new myAdapter());
        return view;
    }

    private void findView(View view) {

    }

    private class myAdapter extends BaseAdapter{

        private int[] args ={1,2,3,4,5,6,7,8,9};

        @Override
        public int getCount(){
            return args.length;
        }
        @Override
        public Object getItem(int position){
            return args[position];
        }
        @Override
        public long getItemId(int position){
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            TextView textView;
            if (convertView==null){
                textView=new TextView(getContext());
            }
            else{
                textView=(TextView) convertView;
            }
            textView.setText("Item"+args[position]);
            textView.setTextSize(18);
            return textView;

        }
    }
}
