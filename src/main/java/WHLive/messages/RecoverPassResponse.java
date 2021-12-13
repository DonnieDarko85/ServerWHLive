package WHLive.messages;

public class RecoverPassResponse extends BaseResponse{
    public RecoverPassResponse(){}

    public RecoverPassResponse(boolean isError, String errorMessage){
        setIsError(isError);
        setErrorMessage(errorMessage);
    }
}