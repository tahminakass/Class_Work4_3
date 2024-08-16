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
        String item = getArguments() != null ? getArguments().getString("item_main") : "";
        loadData(item);
        adapter = new PizzaAdapter(pizzaModel, this);
        binding.rvPizza.setAdapter(adapter);
    }

    private void loadData(String item) {
        pizzaModel.clear();
        if (item.equals("Pizza")) {
            pizzaModel.add(new PizzaModel("Lady bag","https://theclosetonlineshop.com/cdn/shop/files/Diorbag14776-1_1_1445x.jpg?v=1700382700","With love","3500"));
            pizzaModel.add(new PizzaModel("Saddle bag","https://api.platforme.com/api/compose?brand=dior&model=saddle&version=692&p=base:embroidery:m0446criwm928&initials=&size=718&logic=1&initials_profile=style::m0446criwm928&size=3000","With love","2850"));
            pizzaModel.add(new PizzaModel("Large bag","https://cdn-iebpl.nitrocdn.com/RtEwujGzktpavtjebtLFcrvJryJvIPqr/assets/images/optimized/wp-content/uploads/2023/06/fab75cb63da68626d824e3a12fcdac55.WhatsApp_Image_2023-06-22_at_2.17.00_PM-removebg-preview.png","With love","3700"));
            pizzaModel.add(new PizzaModel("Mini bag","https://www.dior.com/couture/ecommerce/media/catalog/product/K/9/1695127325_S0980ONMJ_M81B_E01_GHC.jpg?imwidth=3000","With love","70000"));

        } else if (item.equals("Juice")) {
            pizzaModel.add(new PizzaModel("Dress","https://www.dior.com/couture/ecommerce/media/catalog/product/h/U/1682412351_221R81A3802_X0861_E01_GHC.jpg","With love","3500"));
            pizzaModel.add(new PizzaModel("Dress","https://images.vestiairecollective.com/images/resized/w=1246,q=75,f=auto,/produit/blue-cotton-dior-dress-42586760-1_2.jpg","With love","3500"));
            pizzaModel.add(new PizzaModel("T-shirt","https://www.dior.com/couture/ecommerce/media/catalog/product/h/a/1618248224_143T04A4043_X0200_E01_GHC.jpg","With love","3500"));
            pizzaModel.add(new PizzaModel("T-shirt","https://assets.christiandior.com/is/image/diorprod/154S09AM305X5801_E01?$default_GHC$&crop=379,150,1272,1360&bfc=on&qlt=85","With love","3500"));

        } else if (item.equals("Dessert")) {
            pizzaModel.add(new PizzaModel("Designer shoes","https://media.dior.com/couture/ecommerce/media/catalog/product/Q/s/1682681561_3SN272ZIR_H168_E02_GH.jpg?imwidth=3000","With love","3500"));
            pizzaModel.add(new PizzaModel("Designer shoes","https://www.dior.com/couture/ecommerce/media/catalog/product/0/l/1719413115_3SH118YJP_H069_E03_GHC.jpg","With love","3500"));
            pizzaModel.add(new PizzaModel("Designer shoes","https://images.stockx.com/360/Air-Jordan-1-Retro-High-Dior/Images/Air-Jordan-1-Retro-High-Dior/Lv2/img01.jpg?auto=compress&w=480&dpr=2&updated_at=1635189753&h=320&fm=webp&q=60","With love","3500"));
            pizzaModel.add(new PizzaModel("Designer shoes","https://www.dior.com/couture/ecommerce/media/catalog/product/A/U/1713525077_1SBS11SHOI_Y38I_E02_GHC.jpg","With love","3500"));


        }else if (item.equals("ice-cream")) {
            pizzaModel.add(new PizzaModel("Lady hat","https://ir.ozone.ru/s3/multimedia-7/c1000/6647462215.jpg","With love","3500"));
            pizzaModel.add(new PizzaModel("Lady hat","https://assets.christiandior.com/is/image/diorprod/483C901G6144C610_E03?$default_GHC$&crop=359,669,1214,763&bfc=on&qlt=85","With love","3500"));
            pizzaModel.add(new PizzaModel("Lady hat","https://www.dior.com/couture/ecommerce/media/catalog/product/n/c/1683651919_34DBP924G153_C160_E01_GHC.jpg?imwidth=3000","With love","3500"));
            pizzaModel.add(new PizzaModel("Lady hat","https://www.dior.com/couture/ecommerce/media/catalog/product/n/k/1708969164_42PDP924G180_C920_E01_GHC.jpg","With love","3500"));
        }
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
