package WHLive.messages;

public class GetPersonaggioResponse extends BaseResponse{
    private Long id;
    private String name;
    private String race;
    private String faction;
    private int status;
    private String imageUrl;
    private int careerRank;
    private int corruptionRank;
    private String bg;

    public GetPersonaggioResponse(Long id, String name, String race, String faction, int status, String imageUrl, int careerRank, int corruptionRank, String bg){
        this.id = id;
        this.name = name;
        this.race = race;
        this.faction = faction;
        this.status = status;
        this.imageUrl = imageUrl;
        this.careerRank = careerRank;
        this.corruptionRank = corruptionRank;
        this.bg = bg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCareerRank() {
        return careerRank;
    }

    public void setCareerRank(int careerRank) {
        this.careerRank = careerRank;
    }

    public int getCorruptionRank() {
        return corruptionRank;
    }

    public void setCorruptionRank(int corruptionRank) {
        this.corruptionRank = corruptionRank;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }
}
