package com.example.chapter3.homework;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment  {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        findView(view);
        return view;
    }

    private void findView(View view) {

    }

}