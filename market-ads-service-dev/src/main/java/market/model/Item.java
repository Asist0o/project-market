package market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import market.model.enums.ItemCondition;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
// TODO @Алексей Трояновский
// Добавить все в ликвидбейс коммит
// убрать в сущностях тейбл аннотацию и колумн ( если название нормальное не нужно )
// убрать везде иджер фетч тайп, везде должно быть лези
// убрать везде каскады ( пока без надобности )
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Min(0)
    private Long price;

    @NotNull
    private ItemCondition itemCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_subcategory_id")
    private ItemSubcategory itemSubcategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sizename_id")
    private SizeName sizeName;

    public Item() {
    }

    public Item(Long id, String brand, String model, Long price, ItemCondition itemCondition,
                ItemSubcategory itemSubcategory, SizeName sizeName) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.itemCondition = itemCondition;
        this.itemSubcategory = itemSubcategory;
        this.sizeName = sizeName;
    }

    public Item(String brand, String model, Long price, ItemCondition itemCondition,
                ItemSubcategory itemSubcategory, SizeName sizeName) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.itemCondition = itemCondition;
        this.itemSubcategory = itemSubcategory;
        this.sizeName = sizeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public ItemCondition getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(ItemCondition itemCondition) {
        this.itemCondition = itemCondition;
    }

    public SizeName getSizeName() {
        return sizeName;
    }

    public void setSizeName(SizeName sizeName) {
        this.sizeName = sizeName;
    }

    public ItemSubcategory getItemSubcategory() {
        return itemSubcategory;
    }

    public void setItemSubcategory(ItemSubcategory itemSubcategory) {
        this.itemSubcategory = itemSubcategory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", itemCondition=" + itemCondition +
                ", itemSubcategory=" + itemSubcategory +
                ", sizeName=" + sizeName +
                '}';
    }
}
