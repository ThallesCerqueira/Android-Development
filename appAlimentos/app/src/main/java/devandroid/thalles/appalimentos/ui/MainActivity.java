package devandroid.thalles.appalimentos.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.List;

import devandroid.thalles.appalimentos.listener.OnListClick;
import devandroid.thalles.appalimentos.adapter.FoodAdapter;
import devandroid.thalles.appalimentos.business.FoodBusiness;
import devandroid.thalles.appalimentos.constants.FoodConstants;
import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.R;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FoodEntity> list = new FoodBusiness().getList();

        // 1 - Obter a RecyclerView
        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);

        OnListClick foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID, id);

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        };

        // 2 - Definir um adapter
        FoodAdapter adapter = new FoodAdapter(list, foodListener);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        // 3 - Definir um Layout
        this.mViewHolder.mRecyclerFood.setLayoutManager( new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}