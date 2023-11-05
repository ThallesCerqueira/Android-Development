package devandroid.thalles.appalimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import devandroid.thalles.appalimentos.adapter.FoodAdapter;
import devandroid.thalles.appalimentos.business.FoodBusiness;
import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.R;
import devandroid.thalles.appalimentos.repository.FoodRepository;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FoodEntity> list = new FoodBusiness().getList();

        // 1 - Obter a RecyclerView
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        // 2 - Definir um adapter
        FoodAdapter adapter = new FoodAdapter();
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        // 3 - Definir um Layout
        this.mViewHolder.mRecyclerFood.setLayoutManager( new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}