package stellarburgers.site.enums;

public enum IngredientType {
    BUN("Булки"),
    MAIN("Начинки"),
    SAUCE("Соусы");
    private final String ingredientType;
    IngredientType(String ingredientType) {
        this.ingredientType = ingredientType;}
    public String getMode() {return  ingredientType;}
}
