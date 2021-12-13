package WHLive.messages;

public class RecoverPassRequest extends BaseRequest{
    private String tessera;

    RecoverPassRequest(){}

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    public String getTessera() {
        return tessera;
    }
}