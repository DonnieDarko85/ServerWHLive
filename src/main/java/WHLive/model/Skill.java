package WHLive.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="skill")
public class Skill {
    private Long id;
    private String name;
    private Integer cost;
    private Integer rank;
    private Integer career;
    private Integer mastery;
    private Integer style;
    private Integer advanced;
    private Integer supreme;
    private String description;

    @Id
    @SequenceGenerator(name = "skillSeqGen", sequenceName = "skillSeq", initialValue = 1000, allocationSize = 100)
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public Integer getMastery() {
        return mastery;
    }

    public void setMastery(Integer mastery) {
        this.mastery = mastery;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public Integer getAdvanced() {
        return advanced;
    }

    public void setAdvanced(Integer advanced) {
        this.advanced = advanced;
    }

    public Integer getSupreme() {
        return supreme;
    }

    public void setSupreme(Integer supreme) {
        this.supreme = supreme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}