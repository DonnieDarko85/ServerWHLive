package WHLive.messages;

public class CreateSkillRequest extends BaseRequest {
    private String name;
    private int cost;
    private boolean career;
    private boolean mastery;
    private boolean style;
    private boolean advanced;
    private boolean supreme;
    private String description;
    private int rank;
    private boolean arcaneSpell;
    private boolean divineSpell;
    private boolean alchemyRecipe;
    private boolean rune;

    CreateSkillRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isCareer() {
        return career;
    }

    public void setCareer(boolean career) {
        this.career = career;
    }

    public boolean isMastery() {
        return mastery;
    }

    public void setMastery(boolean mastery) {
        this.mastery = mastery;
    }

    public boolean isStyle() {
        return style;
    }

    public void setStyle(boolean style) {
        this.style = style;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public boolean isSupreme() {
        return supreme;
    }

    public void setSupreme(boolean supreme) {
        this.supreme = supreme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public boolean isArcaneSpell() {
        return arcaneSpell;
    }

    public void setArcaneSpell(boolean arcaneSpell) {
        this.arcaneSpell = arcaneSpell;
    }

    public boolean isDivineSpell() {
        return divineSpell;
    }

    public void setDivineSpell(boolean divineSpell) {
        this.divineSpell = divineSpell;
    }

    public boolean isAlchemyRecipe() {
        return alchemyRecipe;
    }

    public void setAlchemyRecipe(boolean alchemyRecipe) {
        this.alchemyRecipe = alchemyRecipe;
    }

    public boolean isRune() {
        return rune;
    }

    public void setRune(boolean rune) {
        this.rune = rune;
    }
}
