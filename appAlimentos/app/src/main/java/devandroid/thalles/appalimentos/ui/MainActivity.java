package devandroid.thalles.appalimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import devandroid.thalles.appalimentos.listener.OnListClick;
import devandroid.thalles.appalimentos.adapter.FoodAdapter;
import devandroid.thalles.appalimentos.business.FoodBusiness;
import devandroid.thalles.appalimentos.constants.FoodConstants;
import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.R;

public class MainActivity extends AppCompatActivity {

    private FoodBusiness mFoodBusiness = new FoodBusiness();
    private ViewHolder mViewHolder = new ViewHolder();
    private OnListClick mListener;
    private int mFilter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mListener = new OnListClick() {
            @Override
            public void onClick(int id) {

                Bundle bundle = new Bundle();
                bundle.putInt(FoodConstants.FOOD_ID, id);

                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        };

        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_food);
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));

        this.listFood();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionmenu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        if (item.getItemId() == R.id.filter_low) {

            this.mFilter = FoodConstants.FILTER.CAL_LOW;

        } else if (item.getItemId() == R.id.filter_medium) {
            this.mFilter = FoodConstants.FILTER.CAL_MEDIUM;
        } else {
            this.mFilter = FoodConstants.FILTER.CAL_HIGH;
        }

        return super.onOptionsItemSelected(item);

    }

    private void listFood() {
        List<FoodEntity> list = mFoodBusiness.getList(this.mFilter);

        FoodAdapter adapter = new FoodAdapter(list, this.mListener);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}