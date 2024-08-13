package com.example.class_work4_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.class_work4_3.databinding.FragmentRVBinding;

import java.util.ArrayList;

public class RVFragment extends Fragment implements OnItemClick {

    FragmentRVBinding binding;
    PizzaAdapter adapter;
    ArrayList<PizzaModel> pizzaModel = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRVBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        adapter = new PizzaAdapter(pizzaModel, this);
        binding.rvPizza.setAdapter(adapter);
    }

    private void loadData() {
        pizzaModel.add(new PizzaModel("Peperoni", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni ggod pizza", "5"));
        pizzaModel.add(new PizzaModel("Margarita", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni ggod pizza", "5"));
        pizzaModel.add(new PizzaModel("Mexico", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni ggod pizza", "5"));
        pizzaModel.add(new PizzaModel("Italian", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni ggod pizza", "5"));
        pizzaModel.add(new PizzaModel("Asian", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni ggod pizza", "5"));
    }

    @Override
    public void onClick(int position) {
        PizzaModel pizza = pizzaModel.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("pizza", pizza);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.ct_title,
                        fragment).addToBackStack(null).commit();

    }
}
