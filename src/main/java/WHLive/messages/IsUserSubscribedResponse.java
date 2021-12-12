package WHLive.messages;

public class IsUserSubscribedResponse extends BaseResponse {
    private boolean isAlreadySubscribed;

    public IsUserSubscribedResponse(boolean isAlreadySubscribed) {
        this.isAlreadySubscribed = isAlreadySubscribed;
    }

    public IsUserSubscribedResponse(boolean isError, String errorMessage) {
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public boolean isAlreadySubscribed() {
        return isAlreadySubscribed;
    }

    public void setAlreadySubscribed(boolean alreadySubscribed) {
        isAlreadySubscribed = alreadySubscribed;
    }
}
