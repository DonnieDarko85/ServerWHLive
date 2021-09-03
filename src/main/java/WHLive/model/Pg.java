package WHLive.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="pg")
public class Pg {
    private Long id;
    private User user;
    private String name;
    private Date creationDate;
    private String race;
    private String faction;
    private int corruptionRank;
    private int careerRank;
    private String bg;
    private int status;
    private boolean isPrimary;
    private String imageUrl;
    private String notes;

    @Id
    @SequenceGenerator(name = "pgSeqGen", sequenceName = "pgSeq", initialValue = 1000, allocationSize = 100)
    @GeneratedValue(generator = "pgSeqGen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_tessera")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "creation_date")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    @Column(name = "corruption_rank")
    public int getCorruptionRank() {
        return corruptionRank;
    }

    public void setCorruptionRank(int corruptionRank) {
        this.corruptionRank = corruptionRank;
    }

    @Column(name = "career_rank")
    public int getCareerRank() {
        return careerRank;
    }

    public void setCareerRank(int careerRank) {
        this.careerRank = careerRank;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "is_primary")
    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Column(name = "imager_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}