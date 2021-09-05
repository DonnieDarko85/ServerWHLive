package WHLive.messages;

import WHLive.model.Skill;

import java.util.List;

public class AddSkillToPgResponse extends BaseResponse{
    private List<Long> mySkills;

    public AddSkillToPgResponse(boolean isError, String errorMessage, List<Long> mySkill){
        setIsError(isError);
        setErrorMessage(errorMessage);
        this.mySkills = mySkill;
    }

    public List<Long> getMySkills() {
        return mySkills;
    }

    public void setMySkills(List<Long> mySkills) {
        this.mySkills = mySkills;
    }
}