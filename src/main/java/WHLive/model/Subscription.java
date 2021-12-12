package WHLive.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="subscription")
public class Subscription {

    private Long id;
    private int tessera;
    private boolean full;
    private boolean premadePg;
    private boolean dinner1;
    private boolean dinner2;
    private boolean dinner3;

    @Id
    @SequenceGenerator(name = "subscriptionSeqGen", sequenceName = "subscriptionSeq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(generator = "subscriptionSeqGen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTessera() {
        return tessera;
    }

    public void setTessera(int tessera) {
        this.tessera = tessera;
    }
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
}