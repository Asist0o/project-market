package market.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import market.model.enums.ItemCategoryName;
import market.model.enums.GenderType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class ItemSubcategory {

    @Id
    private Long id;

    @NotBlank
    private String subcategoryName;

    @NotNull
    private ItemCategoryName itemCategoryName;

    @NotNull
    private GenderType genderType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "item_subcategories_sizenames",
            joinColumns = @JoinColumn(name = "subcategory_id"),
            inverseJoinColumns = @JoinColumn(name = "sizename_id"))
    @NotNull
    private Set<SizeName> sizeNameSet;

    public ItemSubcategory() {
    }

    public ItemSubcategory(Long id, String subcategoryName, ItemCategoryName itemCategoryName,
                           GenderType genderType, Set<SizeName> sizeNameSet) {
        this.id = id;
        this.subcategoryName = subcategoryName;
        this.itemCategoryName = itemCategoryName;
        this.genderType = genderType;
        this.sizeNameSet = sizeNameSet;
    }

    public ItemSubcategory(String subcategoryName, ItemCategoryName itemCategoryName,
                           GenderType genderType, Set<SizeName> sizeNameSet) {
        this.subcategoryName = subcategoryName;
        this.itemCategoryName = itemCategoryName;
        this.genderType = genderType;
        this.sizeNameSet = sizeNameSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public ItemCategoryName getItemCategory() {
        return itemCategoryName;
    }

    public void setItemCategory(ItemCategoryName itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Set<SizeName> getSizeNameSet() {
        return sizeNameSet;
    }

    public void setSizeNameSet(Set<SizeName> sizeNameSet) {
        this.sizeNameSet = sizeNameSet;
    }

    @Override
    public String toString() {
        return "ItemSubcategory{" +
                "id=" + id +
                ", subcategoryName='" + subcategoryName + '\'' +
                ", itemCategoryName=" + itemCategoryName +
                ", genderType=" + genderType +
                '}';
    }
}
