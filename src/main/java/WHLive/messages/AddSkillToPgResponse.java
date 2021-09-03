package WHLive.messages;

public class AddSkillToPgResponse extends BaseResponse{
    public AddSkillToPgResponse(boolean isError, String errorMessage){
        setIsError(isError);
        setErrorMessage(errorMessage);
    }
}