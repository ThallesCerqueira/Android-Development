package devandroid.thalles.appalimentos.business;

import java.util.List;

import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.repository.FoodRepository;

public class FoodBusiness {

    public List<FoodEntity> getList() {
        return new FoodRepository().getList();
    }

    public FoodEntity get(int id) {
        return new FoodRepository().get(id);
    }

}
