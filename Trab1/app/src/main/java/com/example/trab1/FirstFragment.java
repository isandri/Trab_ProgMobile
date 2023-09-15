package com.example.trab1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trab1.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements RecyclerViewInterface{

    private FragmentFirstBinding binding;
    private ArrayList<Musics> musicsArrayList = new ArrayList<Musics>(){};
    private String[] animalNome;
    private int[] animalCapa;

    private int[] somMusica;
    private String[] duracao;
    private RecyclerView recyclerView;
    private MediaPlayer mediaPlayer;

    private Spinner lugares;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(getContext(), musicsArrayList, this);
        recyclerView.setAdapter(adapter);


        lugares = view.findViewById(R.id.Spinner1);
        ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(getContext().getApplicationContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.tipos));

        lugares.setAdapter(spinadapter);
        lugares.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dataInitialize(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                dataInitialize(5);
            }
        });


    }

    private void dataInitialize(int opcao) {

        switch (opcao){
            case 0:
                musicsArrayList = new ArrayList<>();
                animalNome = getResources().getStringArray(R.array.todos);

                animalCapa = new int[]{
                        R.drawable.f_burro,
                        R.drawable.f_cabra,
                        R.drawable.f_cavalo,
                        R.drawable.f_galinhas,
                        R.drawable.f_galo,
                        R.drawable.f_ovelhas,
                        R.drawable.f_porco,
                        R.drawable.f_vaca,

                        R.drawable.fl_alce,
                        R.drawable.fl_grilo,
                        R.drawable.fl_lobo,
                        R.drawable.fl_raposa,
                        R.drawable.fl_sapo,

                        R.drawable.s_cascavel,
                        R.drawable.s_crocodilo,
                        R.drawable.s_elefante,
                        R.drawable.s_leao,
                        R.drawable.s_leopardo,
                        R.drawable.s_tigre,

                        R.drawable.p_andorinha,
                        R.drawable.p_arara_azul,
                        R.drawable.p_arara_vermelha,
                        R.drawable.p_boca_de_sapo,
                        R.drawable.p_canario,
                        R.drawable.p_corvo,
                        R.drawable.p_mariquita_de_asa_amarela,
                        R.drawable.p_pardal,
                        R.drawable.p_pica_pau,
                        R.drawable.p_rouxinol,
                };

                duracao = getResources().getStringArray(R.array.duracao_todos);


                somMusica = new int[]{
                        R.raw.f_cabra,
                        R.raw.f_cavalo,
                        R.raw.f_galinhas,
                        R.raw.f_galo,
                        R.raw.f_ovelhas,
                        R.raw.f_porco,
                        R.raw.f_vaca,

                        R.raw.fl_alce,
                        R.raw.fl_grilo,
                        R.raw.fl_lobo,
                        R.raw.fl_raposa,
                        R.raw.fl_sapo,

                        R.raw.s_cascavel,
                        R.raw.s_crocodilo,
                        R.raw.s_elefante,
                        R.raw.s_leao,
                        R.raw.s_leopardo,
                        R.raw.s_tigre,

                        R.raw.p_andorinha,
                        R.raw.p_arara_azul,
                        R.raw.p_arara_vermelha,
                        R.raw.p_canario,
                        R.raw.p_cara_de_sapo,
                        R.raw.p_corvo,
                        R.raw.p_mariquita_de_asa_amarela,
                        R.raw.p_pardal,
                        R.raw.p_pica_pau,
                        R.raw.p_rouxinol,
                };

                for (int i=0; i< animalNome.length; i++){
                    Musics music = new Musics(animalNome[i], duracao[i], animalCapa[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                Adapter adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

            case 1:
                musicsArrayList = new ArrayList<>();
                animalNome = getResources().getStringArray(R.array.fazenda);

                animalCapa = new int[]{
                        R.drawable.f_cabra,
                        R.drawable.f_cavalo,
                        R.drawable.f_galinhas,
                        R.drawable.f_galo,
                        R.drawable.f_ovelhas,
                        R.drawable.f_porco,
                        R.drawable.f_vaca,
                };

                duracao = getResources().getStringArray(R.array.duracao_fazenda);

                somMusica = new int[]{
                        R.raw.f_cabra,
                        R.raw.f_cavalo,
                        R.raw.f_galinhas,
                        R.raw.f_galo,
                        R.raw.f_ovelhas,
                        R.raw.f_porco,
                        R.raw.f_vaca,
                };

                for (int i=0; i< animalNome.length; i++){
                    Musics music = new Musics(animalNome[i], duracao[i], animalCapa[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

            case 2:
                musicsArrayList = new ArrayList<>();
                animalNome = getResources().getStringArray(R.array.selva);

                animalCapa = new int[]{
                        R.drawable.s_cascavel,
                        R.drawable.s_crocodilo,
                        R.drawable.s_elefante,
                        R.drawable.s_leao,
                        R.drawable.s_leopardo,
                        R.drawable.s_tigre,
                };

                duracao = getResources().getStringArray(R.array.duracao_selva);

                somMusica = new int[]{
                        R.raw.s_cascavel,
                        R.raw.s_crocodilo,
                        R.raw.s_elefante,
                        R.raw.s_leao,
                        R.raw.s_leopardo,
                        R.raw.s_tigre,
                };

                for (int i=0; i< animalNome.length; i++){
                    Musics music = new Musics(animalNome[i], duracao[i], animalCapa[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

            case 3:
                musicsArrayList = new ArrayList<>();
                animalNome = getResources().getStringArray(R.array.floresta);

                animalCapa = new int[]{
                        R.drawable.fl_alce,
                        R.drawable.fl_grilo,
                        R.drawable.fl_lobo,
                        R.drawable.fl_raposa,
                        R.drawable.fl_sapo,
                };

                duracao = getResources().getStringArray(R.array.duracao_floresta);

                somMusica = new int[]{
                        R.raw.fl_alce,
                        R.raw.fl_grilo,
                        R.raw.fl_lobo,
                        R.raw.fl_raposa,
                        R.raw.fl_sapo,
                };

                for (int i=0; i< animalNome.length; i++){
                    Musics music = new Musics(animalNome[i], duracao[i], animalCapa[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;

            case 4:
                musicsArrayList = new ArrayList<>();
                animalNome = getResources().getStringArray(R.array.passaros);

                animalCapa = new int[]{
                        R.drawable.p_andorinha,
                        R.drawable.p_arara_azul,
                        R.drawable.p_arara_vermelha,
                        R.drawable.p_boca_de_sapo,
                        R.drawable.p_canario,
                        R.drawable.p_corvo,
                        R.drawable.p_mariquita_de_asa_amarela,
                        R.drawable.p_pardal,
                        R.drawable.p_pica_pau,
                        R.drawable.p_rouxinol,
                };

                duracao = getResources().getStringArray(R.array.duracao_passaros);

                somMusica = new int[]{
                        R.raw.p_andorinha,
                        R.raw.p_arara_azul,
                        R.raw.p_arara_vermelha,
                        R.raw.p_cara_de_sapo,
                        R.raw.p_corvo,
                        R.raw.p_mariquita_de_asa_amarela,
                        R.raw.p_pardal,
                        R.raw.p_pica_pau,
                        R.raw.p_rouxinol,
                };

                for (int i=0; i< animalNome.length; i++){
                    Musics music = new Musics(animalNome[i], duracao[i], animalCapa[i], somMusica[i]);
                    musicsArrayList.add(music);
                }
                adapter = new Adapter(getContext(), musicsArrayList, this);
                recyclerView.setAdapter(adapter);
                break;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(int position) {

        ArrayList<Musics> music = musicsArrayList;
        Intent intent = new Intent(getActivity(), PlayerActivity.class);
        intent.putExtra("nome", music.get(position).nome);
        intent.putExtra("capa", music.get(position).animalCapa);
        intent.putExtra("som", music.get(position).somMusica);
        startActivity(intent);
    }
}