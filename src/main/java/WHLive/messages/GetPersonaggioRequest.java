package WHLive.messages;

public class GetPersonaggioRequest extends BaseRequest {
    private int tessera;

    GetPersonaggioRequest(){}

    public int getTessera() {
        return tessera;
    }

    public void setTessera(int tessera) {
        this.tessera = tessera;
    }
}
