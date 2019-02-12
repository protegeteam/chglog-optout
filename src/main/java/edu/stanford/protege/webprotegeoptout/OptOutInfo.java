package edu.stanford.protege.webprotegeoptout;

import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-11
 */
@Document(collection = "opt-out-info")
@TypeAlias("OptOutInfo")
public class OptOutInfo {

    @Id
    private String id;

    private String userId;

    private String emailAddress;

    private String comment;

    private List<OptOutItem> optOutItemList;

    public OptOutInfo() {
    }

    public OptOutInfo(String id,
                      String userId,
                      String emailAddress,
                      List<OptOutItem> optOutItemList) {
        this.id = id;
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.optOutItemList = optOutItemList;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public List<OptOutItem> getOptOutItemList() {
        return optOutItemList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setOptOutItemList(List<OptOutItem> optOutItemList) {
        this.optOutItemList = optOutItemList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return new ToStringCreator("OptOutInfo")
                .append("userId", userId)
                .append("emailAddress", emailAddress)
                .append("comment", comment)
                .append("optOutItemList", optOutItemList)
                .toString();
    }
}
