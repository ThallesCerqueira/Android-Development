package devandroid.thalles.appalimentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import devandroid.thalles.appalimentos.R;
import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.viewholder.FoodViewHolder;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<FoodEntity> mList;

    public FoodAdapter(List<FoodEntity> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.mList.get(position);
        holder.bind(foodEntity);
    }

    @Override
    public int getItemCount() {
        return this.mList.size();
    }
}
