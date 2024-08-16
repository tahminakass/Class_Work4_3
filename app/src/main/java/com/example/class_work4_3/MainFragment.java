package com.example.class_work4_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.class_work4_3.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemClick {

    FragmentMainBinding binding;
    ArrayList<MainModel> mainList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        loadData();
    }


    private void initAdapter() {
        MainAdapter mainAdapter = new MainAdapter(mainList, this);
        binding.rvMain.setAdapter(mainAdapter);
    }

    private void loadData() {
        mainList.add(new MainModel("BAG", "https://www.spot.uz/media/img/2024/04/ZDGIqK17126427544288_l.jpg"));
        mainList.add(new MainModel("CLOTHES", "https://www.worldfinance.com/wp-content/uploads/2017/04/Dior.jpg"));
        mainList.add(new MainModel("SHOES", "https://c8.alamy.com/comp/2RWF2C3/dior-womans-shoes-on-display-inside-the-fashion-store-2RWF2C3.jpg"));
        mainList.add(new MainModel("Hat", "https://dress-mag.com/wp-content/uploads/2021/08/dior-1.jpg"));
    }

    @Override
    public void onClick(int position) {
//        MainModel pizza = mainList.get(position);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("pizza", pizza);
//        RVFragment fragment = new RVFragment();
//        fragment.setArguments(bundle);
//        requireActivity().getSupportFragmentManager().beginTransaction().
//                replace(R.id.ct_title,
//                        fragment).addToBackStack(null).commit();
        RVFragment rvFragment = new RVFragment();
        Bundle bundle = new Bundle();
        if (position == 0) {
            bundle.putString("item_main", "Pizza");
        } else if (position == 1) {
            bundle.putString("item_main", "Juice");
        } else if (position == 2) {
            bundle.putString("item_main", "Dessert");
        } else if (position == 3) {
            bundle.putString("item_main", "ice-cream");
        }
        rvFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ct_title, rvFragment).addToBackStack(null).commit();
    }
}