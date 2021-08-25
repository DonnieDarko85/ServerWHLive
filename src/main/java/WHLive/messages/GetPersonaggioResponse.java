package WHLive.messages;

public class GetPersonaggioResponse extends BaseResponse{
    private String name;
    private String race;
    private String faction;
    private int status;
    private String imageUrl;

    GetPersonaggioResponse(String name, String race, String faction, int status, String imageUrl){
        this.name = name;
        this.race = race;
        this.faction = faction;
        this.status = status;
        this.imageUrl = imageUrl;
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
}
