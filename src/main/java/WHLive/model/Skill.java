package WHLive.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="skill")
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
    private String description;
    private List<Pg> pgs;

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

    public boolean getCareer() {
        return career;
    }

    public void setCareer(boolean career) {
        this.career = career;
    }

    public boolean getMastery() {
        return mastery;
    }

    public void setMastery(boolean mastery) {
        this.mastery = mastery;
    }

    public boolean getStyle() {
        return style;
    }

    public void setStyle(boolean style) {
        this.style = style;
    }

    public boolean getAdvanced() {
        return advanced;
    }

    public void setAdvanced(boolean advanced) {
        this.advanced = advanced;
    }

    public boolean getSupreme() {
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
}