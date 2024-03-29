package devandroid.thalles.appalimentos.repository;

import java.util.ArrayList;
import java.util.List;

import devandroid.thalles.appalimentos.entity.FoodEntity;

public class FoodRepository {

    private List<FoodEntity> mList;

    public FoodRepository() {
        this.mList = new ArrayList<>();

        // Adiciona items
        this.mList.add(new FoodEntity(0, "Arroz", 100, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(1, "Feijão", 110, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(2, "Macarrão", 120, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(3, "Batata", 130, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(4, "Banana", 140, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(5, "Suco de laranja", 150, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(6, "Grão de bico", 160, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(7, "Maça", 170, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(8, "Azeite", 180, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(0, "Arroz", 100, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(1, "Feijão", 110, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(2, "Macarrão", 120, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(3, "Batata", 130, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(4, "Banana", 140, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(6, "Grão de bico", 160, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(7, "Maça", 170, 10, "g", "Observação"));
        this.mList.add(new FoodEntity(8, "Azeite", 180, 10, "g", "Observação"));
    }

    public List<FoodEntity> getList() {
        return this.mList;
    }

    public FoodEntity get(int id) {
        return this.mList.get(id);
    }

}
