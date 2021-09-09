package WHLive.model;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="user")
public class User {

    private Long id;
    private int tessera;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthDate;
    private String email;
    private String authToken;
    private Date authExpire;
    private String password;
    private String sessionToken;
    private Date sessionExpire;

    @Id
    @SequenceGenerator(name = "userSeqGen", sequenceName = "userSeq", initialValue = 1000, allocationSize = 100)
    @GeneratedValue(generator = "userSeqGen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTessera() {
        return tessera;
    }

    public void setTessera(int tessera) {
        this.tessera = tessera;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "auth_token")
    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Column(name = "auth_expire")
    public Date getAuthExpire() {
        return authExpire;
    }

    public void setAuthExpire(Date authExpire) {
        this.authExpire = authExpire;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "session_token")
    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Column(name = "session_expire")
    public Date getSessionExpire() {
        return sessionExpire;
    }

    public void setSessionExpire(Date sessionExpire) {
        this.sessionExpire = sessionExpire;
    }

    @Override
    public String toString(){
        return this.tessera +" - " + this.firstName + " " +this.lastName;
    }
}