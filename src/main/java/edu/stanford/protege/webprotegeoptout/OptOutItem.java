package edu.stanford.protege.webprotegeoptout;

import org.springframework.core.style.ToStringCreator;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2019-02-11
 */
public class OptOutItem {

    private String projectId;

    private String projectName;

    private boolean optOut;

    public OptOutItem() {
    }

    public OptOutItem(String projectId,
                      String projectName,
                      boolean optOut) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.optOut = optOut;
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

    @Override
    public String toString() {
        return new ToStringCreator("OptOutItem").append("projectId", projectId).append("projectName", projectName).append("optOut", optOut).toString();
    }
}
