package WHLive.messages;

public class SubscribeResponse extends BaseResponse{
    public SubscribeResponse() {

    }
    public SubscribeResponse(boolean isError, String errorMessage){
        setIsError(isError);
        setErrorMessage(errorMessage);
    }
}
