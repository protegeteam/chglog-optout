package edu.stanford.protege.webprotegeoptout;

import org.springframework.core.style.ToStringCreator;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-11
 */
public class ProjectInfo {

    private String projectId;

    private String projectName;

    private String createdAt;

    private String modifiedAt;

    private boolean optOut;

    public ProjectInfo() {
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isOptOut() {
        return optOut;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setOptOut(boolean optOut) {
        this.optOut = optOut;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getFormattedModifiedAt() {
        var dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
        return OffsetDateTime.parse(getModifiedAt()).format(dateTimeFormatter);
    }

    public String getFormattedCreatedAt() {
        var dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
        return OffsetDateTime.parse(getCreatedAt()).format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return new ToStringCreator("ProjectInfo").append("projectId", projectId).append("projectName", projectName).append("optOut", optOut).toString();
    }
}
