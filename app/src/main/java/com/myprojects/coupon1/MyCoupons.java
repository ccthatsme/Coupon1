package com.myprojects.coupon1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCoupons#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCoupons extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Coupon coupon = new Coupon();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MyCoupons() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyCoupons.
     */
    // TODO: Rename and change types and number of parameters
    public static MyCoupons newInstance(String param1, String param2) {
        MyCoupons fragment = new MyCoupons();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle intent = getArguments();

        if (intent != null) {

            coupon = intent.getParcelable("coupon_object");
        }

        //coupon = intent.getExtra("coupon_object");




        //RecyclerView pizzaRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_my_coupons, container, false);

        View view = inflater.inflate(R.layout.fragment_my_coupons, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.coupon_recycler);


        //this is for the image
        Bitmap[] couponImage = new Bitmap[1];
        couponImage[0] = coupon.getCouponImage();

        //this is for description
        String[] couponDescription = new String[1];
        couponDescription[0] = coupon.getDescription();


        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(couponImage,couponDescription);
        recyclerView.setAdapter(adapter);
        GridLayoutManager grid = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(grid);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_coupons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FloatingActionButton fb = getView().findViewById(R.id.floating);

        View.OnClickListener onClickListener= new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddCoupon.class);
                startActivity(intent);

            }
        };

        fb.setOnClickListener((View.OnClickListener) onClickListener);
        super.onViewCreated(view, savedInstanceState);
    }
}
