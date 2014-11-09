package com.ydp.yunmigroup.ui.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ydp.yunmigroup.R;

public class ContentFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String KEY_TIP = "tip";

    // TODO: Rename and change types of parameters
    private String tip;
    private String mParam2;

    private TextView tvTip;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param tip Parameter 1.
     * @return A new instance of fragment ContentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentFragment newInstance(String tip) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(KEY_TIP, tip);
        fragment.setArguments(args);
        return fragment;
    }

    public ContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tip = getArguments().getString(KEY_TIP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTip = (TextView) view.findViewById(R.id.tv_tip);
        tvTip.setText(tip);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

}
