package devandroid.thalles.appalimentos.business;

import java.util.ArrayList;
import java.util.List;

import devandroid.thalles.appalimentos.constants.FoodConstants;
import devandroid.thalles.appalimentos.entity.FoodEntity;
import devandroid.thalles.appalimentos.repository.FoodRepository;

public class FoodBusiness {

    private FoodRepository mFoodRepository = new FoodRepository();

    public List<FoodEntity> getList(int filter) {

        List<FoodEntity> list = this.mFoodRepository.getList();
        List<FoodEntity> filtered = new ArrayList<>();

        if(filter == FoodConstants.FILTER.NO_FILTER) {
            return list;
        }

        for(FoodEntity f: list) {

            if (filter == FoodConstants.FILTER.CAL_LOW) {
                if(f.getCalories() <= 99) {
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_MEDIUM) {
                if(f.getCalories() >= 100 && f.getCalories() <= 199 ) {
                    filtered.add(f);
                }
            } else if (filter == FoodConstants.FILTER.CAL_HIGH) {
                if(f.getCalories() >= 200) {
                    filtered.add(f);
                }
            }

        }




        return filtered;

    }

    public FoodEntity get(int id) {
        return this.mFoodRepository.get(id);
    }

}
