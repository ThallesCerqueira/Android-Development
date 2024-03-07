package devandroid.thalles.appalimentos.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import devandroid.thalles.appalimentos.R;
import devandroid.thalles.appalimentos.business.FoodBusiness;
import devandroid.thalles.appalimentos.constants.FoodConstants;
import devandroid.thalles.appalimentos.entity.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private final ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Elementos da interface
        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);

        getData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            int id = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity foodEntity =  new FoodBusiness().get(id);

            this.mViewHolder.mTextName.setText(foodEntity.getName());
            this.mViewHolder.mTextCalories.setText(String.valueOf(foodEntity.getCalories()));
        }
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
    }
}