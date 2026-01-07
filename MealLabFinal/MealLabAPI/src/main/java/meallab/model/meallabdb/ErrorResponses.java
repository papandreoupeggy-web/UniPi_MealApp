package meallab.model.meallabdb;

import java.util.ArrayList; //for Ingredient and Measures to viewed as a list//
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "meals"})
public class ErrorResponses {

    @JsonProperty("meals")
    private List<ErrorResponses> meals;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("meals")
    public List<ErrorResponses> getMeals() {
        return meals;
    }

    @JsonProperty("meals")
    public void setMeals(List<ErrorResponses> meals) {
        this.meals = meals;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
//inner class//
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
        "idMeal",
        "strMeal",
        "strMealAlternate",
        "strCategory",
        "strArea",
        "strInstructions",
        "strMealThumb",
        "strTags",
        "strYoutube",
        "strIngredient1",
        "strIngredient2",
        "strIngredient3",
        "strIngredient4",
        "strIngredient5",
        "strIngredient6",
        "strIngredient7",
        "strIngredient8",
        "strIngredient9",
        "strIngredient10",
        "strIngredient11",
        "strIngredient12",
        "strIngredient13",
        "strIngredient14",
        "strIngredient15",
        "strIngredient16",
        "strIngredient17",
        "strIngredient18",
        "strIngredient19",
        "strIngredient20",
        "strMeasure1",
        "strMeasure2",
        "strMeasure3",
        "strMeasure4",
        "strMeasure5",
        "strMeasure6",
        "strMeasure7",
        "strMeasure8",
        "strMeasure9",
        "strMeasure10",
        "strMeasure11",
        "strMeasure12",
        "strMeasure13",
        "strMeasure14",
        "strMeasure15",
        "strMeasure16",
        "strMeasure17",
        "strMeasure18",
        "strMeasure19",
        "strMeasure20",
        "strSource",
        "strImageSource",
        "strCreativeCommonsConfirmed",
        "dateModified"
    })
    public static class ErrorResponse {

        // list methods
        
        public List<String> getIngredientsList() {
            List<String> items = new ArrayList<>();
            
            addIfPresent(items, strMeasure1, strIngredient1);
            addIfPresent(items, strMeasure2, strIngredient2);
            addIfPresent(items, strMeasure3, strIngredient3);
            addIfPresent(items, strMeasure4, strIngredient4);
            addIfPresent(items, strMeasure5, strIngredient5);
            addIfPresent(items, strMeasure6, strIngredient6);
            addIfPresent(items, strMeasure7, strIngredient7);
            addIfPresent(items, strMeasure8, strIngredient8);
            addIfPresent(items, strMeasure9, strIngredient9);
            addIfPresent(items, strMeasure10, strIngredient10);
            addIfPresent(items, strMeasure11, strIngredient11);
            addIfPresent(items, strMeasure12, strIngredient12);
            addIfPresent(items, strMeasure13, strIngredient13);
            addIfPresent(items, strMeasure14, strIngredient14);
            addIfPresent(items, strMeasure15, strIngredient15);
            addIfPresent(items, strMeasure16, strIngredient16);
            addIfPresent(items, strMeasure17, strIngredient17);
            addIfPresent(items, strMeasure18, strIngredient18);
            addIfPresent(items, strMeasure19, strIngredient19);
            addIfPresent(items, strMeasure20, strIngredient20);
            
            return items;
        }

        private void addIfPresent(List<String> list, String measure, String ingredient) {
            if (ingredient != null && !ingredient.trim().isEmpty()) {
                String fullEntry = (measure != null ? measure : "") + " " + ingredient;
                list.add(fullEntry.trim());
            }
        }

        @JsonProperty("idMeal")
        private String idMeal;
        @JsonProperty("strMeal")
        private String strMeal;
        @JsonProperty("strMealAlternate")
        private Object strMealAlternate;
        @JsonProperty("strCategory")
        private String strCategory;
        @JsonProperty("strArea")
        private String strArea;
        @JsonProperty("strInstructions")
        private String strInstructions;
        @JsonProperty("strMealThumb")
        private String strMealThumb;
        @JsonProperty("strTags")
        private Object strTags;
        @JsonProperty("strYoutube")
        private String strYoutube;
        
        @JsonProperty("strIngredient1") private String strIngredient1;
        @JsonProperty("strIngredient2") private String strIngredient2;
        @JsonProperty("strIngredient3") private String strIngredient3;
        @JsonProperty("strIngredient4") private String strIngredient4;
        @JsonProperty("strIngredient5") private String strIngredient5;
        @JsonProperty("strIngredient6") private String strIngredient6;
        @JsonProperty("strIngredient7") private String strIngredient7;
        @JsonProperty("strIngredient8") private String strIngredient8;
        @JsonProperty("strIngredient9") private String strIngredient9;
        @JsonProperty("strIngredient10") private String strIngredient10;
        @JsonProperty("strIngredient11") private String strIngredient11;
        @JsonProperty("strIngredient12") private String strIngredient12;
        @JsonProperty("strIngredient13") private String strIngredient13;
        @JsonProperty("strIngredient14") private String strIngredient14;
        @JsonProperty("strIngredient15") private String strIngredient15;
        @JsonProperty("strIngredient16") private String strIngredient16;
        @JsonProperty("strIngredient17") private String strIngredient17;
        @JsonProperty("strIngredient18") private String strIngredient18;
        @JsonProperty("strIngredient19") private String strIngredient19;
        @JsonProperty("strIngredient20") private String strIngredient20;
        
        @JsonProperty("strMeasure1") private String strMeasure1;
        @JsonProperty("strMeasure2") private String strMeasure2;
        @JsonProperty("strMeasure3") private String strMeasure3;
        @JsonProperty("strMeasure4") private String strMeasure4;
        @JsonProperty("strMeasure5") private String strMeasure5;
        @JsonProperty("strMeasure6") private String strMeasure6;
        @JsonProperty("strMeasure7") private String strMeasure7;
        @JsonProperty("strMeasure8") private String strMeasure8;
        @JsonProperty("strMeasure9") private String strMeasure9;
        @JsonProperty("strMeasure10") private String strMeasure10;
        @JsonProperty("strMeasure11") private String strMeasure11;
        @JsonProperty("strMeasure12") private String strMeasure12;
        @JsonProperty("strMeasure13") private String strMeasure13;
        @JsonProperty("strMeasure14") private String strMeasure14;
        @JsonProperty("strMeasure15") private String strMeasure15;
        @JsonProperty("strMeasure16") private String strMeasure16;
        @JsonProperty("strMeasure17") private String strMeasure17;
        @JsonProperty("strMeasure18") private String strMeasure18;
        @JsonProperty("strMeasure19") private String strMeasure19;
        @JsonProperty("strMeasure20") private String strMeasure20;

        @JsonProperty("strSource")
        private String strSource;
        @JsonProperty("strImageSource")
        private Object strImageSource;
        @JsonProperty("strCreativeCommonsConfirmed")
        private Object strCreativeCommonsConfirmed;
        @JsonProperty("dateModified")
        private String dateModified;
        
        @JsonIgnore
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        // setters and getters for each object

        @JsonProperty("idMeal")
        public String getIdMeal() {
            return idMeal;
        }

        @JsonProperty("idMeal")
        public void setIdMeal(String idMeal) {
            this.idMeal = idMeal;
        }

        @JsonProperty("strMeal")
        public String getStrMeal() {
            return strMeal;
        }

        @JsonProperty("strMeal")
        public void setStrMeal(String strMeal) {
            this.strMeal = strMeal;
        }

        @JsonProperty("strMealAlternate")
        public Object getStrMealAlternate() {
            return strMealAlternate;
        }

        @JsonProperty("strMealAlternate")
        public void setStrMealAlternate(Object strMealAlternate) {
            this.strMealAlternate = strMealAlternate;
        }

        @JsonProperty("strCategory")
        public String getStrCategory() {
            return strCategory;
        }

        @JsonProperty("strCategory")
        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        @JsonProperty("strArea")
        public String getStrArea() {
            return strArea;
        }

        @JsonProperty("strArea")
        public void setStrArea(String strArea) {
            this.strArea = strArea;
        }

        @JsonProperty("strInstructions")
        public String getStrInstructions() {
            return strInstructions;
        }

        @JsonProperty("strInstructions")
        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }

        @JsonProperty("strMealThumb")
        public String getStrMealThumb() {
            return strMealThumb;
        }

        @JsonProperty("strMealThumb")
        public void setStrMealThumb(String strMealThumb) {
            this.strMealThumb = strMealThumb;
        }

        @JsonProperty("strTags")
        public Object getStrTags() {
            return strTags;
        }

        @JsonProperty("strTags")
        public void setStrTags(Object strTags) {
            this.strTags = strTags;
        }

        @JsonProperty("strYoutube")
        public String getStrYoutube() {
            return strYoutube;
        }

        @JsonProperty("strYoutube")
        public void setStrYoutube(String strYoutube) {
            this.strYoutube = strYoutube;
        }

        @JsonProperty("strIngredient1")
        public String getStrIngredient1() {
            return strIngredient1;
        }

        @JsonProperty("strIngredient1")
        public void setStrIngredient1(String strIngredient1) {
            this.strIngredient1 = strIngredient1;
        }

        @JsonProperty("strIngredient2")
        public String getStrIngredient2() {
            return strIngredient2;
        }

        @JsonProperty("strIngredient2")
        public void setStrIngredient2(String strIngredient2) {
            this.strIngredient2 = strIngredient2;
        }

        @JsonProperty("strIngredient3")
        public String getStrIngredient3() {
            return strIngredient3;
        }

        @JsonProperty("strIngredient3")
        public void setStrIngredient3(String strIngredient3) {
            this.strIngredient3 = strIngredient3;
        }

        @JsonProperty("strIngredient4")
        public String getStrIngredient4() {
            return strIngredient4;
        }

        @JsonProperty("strIngredient4")
        public void setStrIngredient4(String strIngredient4) {
            this.strIngredient4 = strIngredient4;
        }

        @JsonProperty("strIngredient5")
        public String getStrIngredient5() {
            return strIngredient5;
        }

        @JsonProperty("strIngredient5")
        public void setStrIngredient5(String strIngredient5) {
            this.strIngredient5 = strIngredient5;
        }

        @JsonProperty("strIngredient6")
        public String getStrIngredient6() {
            return strIngredient6;
        }

        @JsonProperty("strIngredient6")
        public void setStrIngredient6(String strIngredient6) {
            this.strIngredient6 = strIngredient6;
        }

        @JsonProperty("strIngredient7")
        public String getStrIngredient7() {
            return strIngredient7;
        }

        @JsonProperty("strIngredient7")
        public void setStrIngredient7(String strIngredient7) {
            this.strIngredient7 = strIngredient7;
        }

        @JsonProperty("strIngredient8")
        public String getStrIngredient8() {
            return strIngredient8;
        }

        @JsonProperty("strIngredient8")
        public void setStrIngredient8(String strIngredient8) {
            this.strIngredient8 = strIngredient8;
        }

        @JsonProperty("strIngredient9")
        public String getStrIngredient9() {
            return strIngredient9;
        }

        @JsonProperty("strIngredient9")
        public void setStrIngredient9(String strIngredient9) {
            this.strIngredient9 = strIngredient9;
        }

        @JsonProperty("strIngredient10")
        public String getStrIngredient10() {
            return strIngredient10;
        }

        @JsonProperty("strIngredient10")
        public void setStrIngredient10(String strIngredient10) {
            this.strIngredient10 = strIngredient10;
        }

        @JsonProperty("strIngredient11")
        public String getStrIngredient11() {
            return strIngredient11;
        }

        @JsonProperty("strIngredient11")
        public void setStrIngredient11(String strIngredient11) {
            this.strIngredient11 = strIngredient11;
        }

        @JsonProperty("strIngredient12")
        public String getStrIngredient12() {
            return strIngredient12;
        }

        @JsonProperty("strIngredient12")
        public void setStrIngredient12(String strIngredient12) {
            this.strIngredient12 = strIngredient12;
        }

        @JsonProperty("strIngredient13")
        public String getStrIngredient13() {
            return strIngredient13;
        }

        @JsonProperty("strIngredient13")
        public void setStrIngredient13(String strIngredient13) {
            this.strIngredient13 = strIngredient13;
        }

        @JsonProperty("strIngredient14")
        public String getStrIngredient14() {
            return strIngredient14;
        }

        @JsonProperty("strIngredient14")
        public void setStrIngredient14(String strIngredient14) {
            this.strIngredient14 = strIngredient14;
        }

        @JsonProperty("strIngredient15")
        public String getStrIngredient15() {
            return strIngredient15;
        }

        @JsonProperty("strIngredient15")
        public void setStrIngredient15(String strIngredient15) {
            this.strIngredient15 = strIngredient15;
        }

        @JsonProperty("strIngredient16")
        public String getStrIngredient16() {
            return strIngredient16;
        }

        @JsonProperty("strIngredient16")
        public void setStrIngredient16(String strIngredient16) {
            this.strIngredient16 = strIngredient16;
        }

        @JsonProperty("strIngredient17")
        public String getStrIngredient17() {
            return strIngredient17;
        }

        @JsonProperty("strIngredient17")
        public void setStrIngredient17(String strIngredient17) {
            this.strIngredient17 = strIngredient17;
        }

        @JsonProperty("strIngredient18")
        public String getStrIngredient18() {
            return strIngredient18;
        }

        @JsonProperty("strIngredient18")
        public void setStrIngredient18(String strIngredient18) {
            this.strIngredient18 = strIngredient18;
        }

        @JsonProperty("strIngredient19")
        public String getStrIngredient19() {
            return strIngredient19;
        }

        @JsonProperty("strIngredient19")
        public void setStrIngredient19(String strIngredient19) {
            this.strIngredient19 = strIngredient19;
        }

        @JsonProperty("strIngredient20")
        public String getStrIngredient20() {
            return strIngredient20;
        }

        @JsonProperty("strIngredient20")
        public void setStrIngredient20(String strIngredient20) {
            this.strIngredient20 = strIngredient20;
        }

        @JsonProperty("strMeasure1")
        public String getStrMeasure1() {
            return strMeasure1;
        }

        @JsonProperty("strMeasure1")
        public void setStrMeasure1(String strMeasure1) {
            this.strMeasure1 = strMeasure1;
        }

        @JsonProperty("strMeasure2")
        public String getStrMeasure2() {
            return strMeasure2;
        }

        @JsonProperty("strMeasure2")
        public void setStrMeasure2(String strMeasure2) {
            this.strMeasure2 = strMeasure2;
        }

        @JsonProperty("strMeasure3")
        public String getStrMeasure3() {
            return strMeasure3;
        }

        @JsonProperty("strMeasure3")
        public void setStrMeasure3(String strMeasure3) {
            this.strMeasure3 = strMeasure3;
        }

        @JsonProperty("strMeasure4")
        public String getStrMeasure4() {
            return strMeasure4;
        }

        @JsonProperty("strMeasure4")
        public void setStrMeasure4(String strMeasure4) {
            this.strMeasure4 = strMeasure4;
        }

        @JsonProperty("strMeasure5")
        public String getStrMeasure5() {
            return strMeasure5;
        }

        @JsonProperty("strMeasure5")
        public void setStrMeasure5(String strMeasure5) {
            this.strMeasure5 = strMeasure5;
        }

        @JsonProperty("strMeasure6")
        public String getStrMeasure6() {
            return strMeasure6;
        }

        @JsonProperty("strMeasure6")
        public void setStrMeasure6(String strMeasure6) {
            this.strMeasure6 = strMeasure6;
        }

        @JsonProperty("strMeasure7")
        public String getStrMeasure7() {
            return strMeasure7;
        }

        @JsonProperty("strMeasure7")
        public void setStrMeasure7(String strMeasure7) {
            this.strMeasure7 = strMeasure7;
        }

        @JsonProperty("strMeasure8")
        public String getStrMeasure8() {
            return strMeasure8;
        }

        @JsonProperty("strMeasure8")
        public void setStrMeasure8(String strMeasure8) {
            this.strMeasure8 = strMeasure8;
        }

        @JsonProperty("strMeasure9")
        public String getStrMeasure9() {
            return strMeasure9;
        }

        @JsonProperty("strMeasure9")
        public void setStrMeasure9(String strMeasure9) {
            this.strMeasure9 = strMeasure9;
        }

        @JsonProperty("strMeasure10")
        public String getStrMeasure10() {
            return strMeasure10;
        }

        @JsonProperty("strMeasure10")
        public void setStrMeasure10(String strMeasure10) {
            this.strMeasure10 = strMeasure10;
        }

        @JsonProperty("strMeasure11")
        public String getStrMeasure11() {
            return strMeasure11;
        }

        @JsonProperty("strMeasure11")
        public void setStrMeasure11(String strMeasure11) {
            this.strMeasure11 = strMeasure11;
        }

        @JsonProperty("strMeasure12")
        public String getStrMeasure12() {
            return strMeasure12;
        }

        @JsonProperty("strMeasure12")
        public void setStrMeasure12(String strMeasure12) {
            this.strMeasure12 = strMeasure12;
        }

        @JsonProperty("strMeasure13")
        public String getStrMeasure13() {
            return strMeasure13;
        }

        @JsonProperty("strMeasure13")
        public void setStrMeasure13(String strMeasure13) {
            this.strMeasure13 = strMeasure13;
        }

        @JsonProperty("strMeasure14")
        public String getStrMeasure14() {
            return strMeasure14;
        }

        @JsonProperty("strMeasure14")
        public void setStrMeasure14(String strMeasure14) {
            this.strMeasure14 = strMeasure14;
        }

        @JsonProperty("strMeasure15")
        public String getStrMeasure15() {
            return strMeasure15;
        }

        @JsonProperty("strMeasure15")
        public void setStrMeasure15(String strMeasure15) {
            this.strMeasure15 = strMeasure15;
        }

        @JsonProperty("strMeasure16")
        public String getStrMeasure16() {
            return strMeasure16;
        }

        @JsonProperty("strMeasure16")
        public void setStrMeasure16(String strMeasure16) {
            this.strMeasure16 = strMeasure16;
        }

        @JsonProperty("strMeasure17")
        public String getStrMeasure17() {
            return strMeasure17;
        }

        @JsonProperty("strMeasure17")
        public void setStrMeasure17(String strMeasure17) {
            this.strMeasure17 = strMeasure17;
        }

        @JsonProperty("strMeasure18")
        public String getStrMeasure18() {
            return strMeasure18;
        }

        @JsonProperty("strMeasure18")
        public void setStrMeasure18(String strMeasure18) {
            this.strMeasure18 = strMeasure18;
        }

        @JsonProperty("strMeasure19")
        public String getStrMeasure19() {
            return strMeasure19;
        }

        @JsonProperty("strMeasure19")
        public void setStrMeasure19(String strMeasure19) {
            this.strMeasure19 = strMeasure19;
        }

        @JsonProperty("strMeasure20")
        public String getStrMeasure20() {
            return strMeasure20;
        }

        @JsonProperty("strMeasure20")
        public void setStrMeasure20(String strMeasure20) {
            this.strMeasure20 = strMeasure20;
        }

        @JsonProperty("strSource")
        public String getStrSource() {
            return strSource;
        }

        @JsonProperty("strSource")
        public void setStrSource(String strSource) {
            this.strSource = strSource;
        }

        @JsonProperty("strImageSource")
        public Object getStrImageSource() {
            return strImageSource;
        }

        @JsonProperty("strImageSource")
        public void setStrImageSource(Object strImageSource) {
            this.strImageSource = strImageSource;
        }

        @JsonProperty("strCreativeCommonsConfirmed")
        public Object getStrCreativeCommonsConfirmed() {
            return strCreativeCommonsConfirmed;
        }

        @JsonProperty("strCreativeCommonsConfirmed")
        public void setStrCreativeCommonsConfirmed(Object strCreativeCommonsConfirmed) {
            this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        }

        @JsonProperty("dateModified")
        public String getDateModified() {
            return dateModified;
        }

        @JsonProperty("dateModified")
        public void setDateModified(String dateModified) {
            this.dateModified = dateModified;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }
    }
}