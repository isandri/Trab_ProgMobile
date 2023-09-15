package com.example.trab1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridView galleryGridView = view.findViewById(R.id.idGridViewGallery);

        ArrayList<GalleryModel> galleryModelArrayList = new ArrayList<>();

        galleryModelArrayList.add(new GalleryModel(R.drawable.p_andorinha));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_canario));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_corvo));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_arara_azul));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_pardal));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_arara_vermelha));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_boca_de_sapo));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_mariquita_de_asa_amarela));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_pica_pau));
        galleryModelArrayList.add(new GalleryModel(R.drawable.p_rouxinol));


        GalleryAdapter adapter = new GalleryAdapter(view.getContext(), galleryModelArrayList);

        galleryGridView.setAdapter(adapter);
    }
}