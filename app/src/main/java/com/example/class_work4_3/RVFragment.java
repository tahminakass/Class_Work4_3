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
        pizzaModel.add(new PizzaModel("Peperoni", "https://www.allrecipes.com/thmb/9UTj7kZBJDqory0cdEv_bw6Ef_0=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/48727-Mikes-homemade-pizza-DDMFS-beauty-2x1-BG-2976-d5926c9253d3486bbb8a985172604291.jpg", "Peperoni good pizza", "5"));
        pizzaModel.add(new PizzaModel("Margarita", "https://www.foodandwine.com/thmb/3kzG4PWOAgZIIfZwMBLKqoTkaGQ=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/margherita-pizza-with-argula-and-prosciutto-FT-RECIPE0721-04368ec288a84d2e997573aca0001d98.jpg", "Margarita good pizza", "10"));
        pizzaModel.add(new PizzaModel("Mexico", "https://www.eatingwell.com/thmb/k3RhYf4XhAeqAejYjdInOlSOp6I=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/gettyimages-1124303516-36413b5bf61f45f1b7d18d90000b56b7.jpg", "Mexico good pizza", "12"));
        pizzaModel.add(new PizzaModel("Italian", "https://recipesblob.oetker.in/assets/d8a4b00c292a43adbb9f96798e028f01/1272x764/pizza-pollo-arrostojpg.jpg", "Italian good pizza", "5"));
        pizzaModel.add(new PizzaModel("Asian", "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/216054.jpg", "Asian ggod pizza", "6"));
        pizzaModel.add(new PizzaModel("Cocacola", "https://www.gunz.cc/%D0%A0%D0%B8%D1%81%D1%83%D0%BD%D0%BE%D0%BA-%D0%BF%D1%80%D0%BE%D0%B4%D1%83%D0%BA%D1%82%D0%B0/Coca-Cola-033l-%D0%A0%D0%B8%D1%81%D1%83%D0%BD%D0%BE%D0%BA-1.webp?SFRXZPIM=V65ID000003232Next14_42336_rd704", "Colla healthy drink", "3"));
        pizzaModel.add(new PizzaModel("Fanta", "https://sp-ao.shortpixel.ai/client/to_webp,q_glossy,ret_img,w_1024,h_768/https://caspianfood.co.uk/wp-content/uploads/2024/01/580b57fbd9996e24bc43c10f-1-1.png", "Fanta healthy drink", "5"));
        pizzaModel.add(new PizzaModel("Pepsi", "https://marino.ae/cdn/shop/files/Pepsi-Can-300-ml-24x300ml-_1-carton_-Marino.AE-234569456.jpg?v=1707548981&width=750", "Pepsi healthy drink", "3"));
        pizzaModel.add(new PizzaModel("Sprite", "https://126956000.cdn6.editmysite.com/uploads/1/2/6/9/126956000/s848309795171683491_p221_i1_w1500.jpeg", "Sprite healthy drink", "3"));
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
