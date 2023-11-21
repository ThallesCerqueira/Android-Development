package devandroid.thalles.appalimentos.viewholder;

import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.PluralsRes;
import androidx.recyclerview.widget.RecyclerView;

import devandroid.thalles.appalimentos.R;
import devandroid.thalles.appalimentos.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextName;
    private TextView mTextCalories;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextName =  itemView.findViewById(R.id.text_name);
        mTextCalories =  itemView.findViewById(R.id.text_calories);
    }

    public void bind(FoodEntity food) {
        this.mTextName.setText(String.valueOf(food.getName()));
        this.mTextCalories.setText(String.valueOf(food.getCalories()));
    }
}
