package CustomerApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_DETAILS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty("firstName")
    @Column(name="FIRST_NAME_C")
    private String firstName;
    @JsonProperty("lastName")
    @Column(name = "LAST_NAME_C")
    private String lastName;
    @JsonProperty("middleName")
    @Column(name="MIDDLE_NAME_C")
    private String middleName;
    @JsonProperty("emailId")
    @Column(name="EMAIL_ID_C")
    private String emailId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
