package WHLive.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "skill")
public class Skill {
    private Long id;
    private String name;
    private Integer cost;
    private Integer rank;
    private boolean career;
    private boolean mastery;
    private boolean style;
    private boolean advanced;
    private boolean supreme;
    private boolean arcaneSpell;
    private boolean divineSpell;
    private boolean alchemyRecipe;
    private boolean rune;
    private String description;

    @Id
    @SequenceGenerator(name = "skillSeqGen", sequenceName = "skillSeq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(generator = "skillSeqGen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Column(name = "skill_rank")
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public boolean isCareer() {
        return career;
    }

    public boolean isMastery() {
        return mastery;
    }

    @Column(name = "combat_style")
    public boolean isStyle() {
        return style;
    }

    public boolean isAdvanced() {
        return advanced;
    }

    public boolean isSupreme() {
        return supreme;
    }

    public void setCareer(boolean career) {
        this.career = career;
    }

    public void setMastery(boolean mastery) {
        this.mastery = mastery;
    }

    public void setStyle(boolean style) {
        this.style = style;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public void setSupreme(boolean supreme) {
        this.supreme = supreme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "arcane_spell")
    public boolean isArcaneSpell() {
        return arcaneSpell;
    }

    public void setArcaneSpell(boolean arcaneSpell) {
        this.arcaneSpell = arcaneSpell;
    }

    @Column(name = "divine_spell")
    public boolean isDivineSpell() {
        return divineSpell;
    }

    public void setDivineSpell(boolean divineSpell) {
        this.divineSpell = divineSpell;
    }

    @Column(name = "alchemy_recipe")
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

    public String getDescription() {
        return description;
    }
}