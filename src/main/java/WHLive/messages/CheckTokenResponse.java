package WHLive.messages;

public class CheckTokenResponse extends BaseResponse{
    private String sessionToken;
    private int tessera;
    private String firstName;
    private String lastName;

    public CheckTokenResponse(String sessionToken, int tessera, String firstName, String lastName){
        this.sessionToken = sessionToken;
        this.tessera = tessera;
        this.firstName = firstName;
        this.lastName= lastName;
    }

    public CheckTokenResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public int getTessera() {
        return tessera;
    }

    public void setTessera(int tessera) {
        this.tessera = tessera;
    }public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}