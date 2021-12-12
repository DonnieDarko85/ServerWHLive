package WHLive.messages;

public class SubscribeRequest extends BaseRequest {
    private boolean full;
    private boolean premadePg;
    private boolean dinner1;
    private boolean dinner2;
    private boolean dinner3;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isPremadePg() {
        return premadePg;
    }

    public void setPremadePg(boolean premadePg) {
        this.premadePg = premadePg;
    }

    public boolean isDinner1() {
        return dinner1;
    }

    public void setDinner1(boolean dinner1) {
        this.dinner1 = dinner1;
    }

    public boolean isDinner2() {
        return dinner2;
    }

    public void setDinner2(boolean dinner2) {
        this.dinner2 = dinner2;
    }

    public boolean isDinner3() {
        return dinner3;
    }

    public void setDinner3(boolean dinner3) {
        this.dinner3 = dinner3;
    }

    SubscribeRequest(){

    }
}
