package devandroid.thalles.appalimentos.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import devandroid.thalles.appalimentos.R;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Elementos da interface
        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_calories);
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
    }
}