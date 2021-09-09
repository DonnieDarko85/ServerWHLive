package WHLive.messages;
import WHLive.model.Skill;

public class AllSkillResponse extends BaseResponse{
    private Iterable<Skill> skills;

    public AllSkillResponse(Iterable<Skill> skills){
        this.skills = skills;
        setIsError(false);
    }

    public AllSkillResponse(Iterable<Skill> skills, boolean isError, String errorMessage){
        this.skills = skills;
        setIsError(isError);
        setErrorMessage(errorMessage);
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }
}