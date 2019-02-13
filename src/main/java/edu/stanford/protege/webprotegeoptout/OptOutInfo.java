package edu.stanford.protege.webprotegeoptout;

import org.springframework.core.style.ToStringCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-11
 */
@Document(collection = "OptOutInfo")
@TypeAlias("OptOutInfo")
public class OptOutInfo {

    @Id
    private String id;

    private String userId;

    private String emailAddress;

    private String viewedAt;

    private String comment;

    private List<OptOutItem> projects;

    public OptOutInfo() {
    }

    public OptOutInfo(String id,
                      String userId,
                      String emailAddress,
                      String comment,
                      List<OptOutItem> projects) {
        this.id = id;
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.comment = comment;
        this.projects = projects;
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

    public List<OptOutItem> getProjects() {
        return projects;
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

    public String getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(String viewedAt) {
        this.viewedAt = viewedAt;
    }

    public void setProjects(List<OptOutItem> projects) {
        this.projects = projects;
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
                .append("projects", projects)
                .toString();
    }
}
