package WHLive.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="mygrv_pg")
public class PG {
    private Long id;
    private User user;
    private String name;
    private Date creationDate;
    private String race;
    private String faction;
    private int corruptionRank;
    private int statusRank;
    private String bg;
    private int status;
    private boolean isPrimary;
    private String imageUrl;
    private String notes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "status_rank")
    public int getStatusRank() {
        return statusRank;
    }

    public void setStatusRank(int statusRank) {
        this.statusRank = statusRank;
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