package org.jetbrains.idea.plugin.gitbar;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;

/**
 * @author marlboro027@foxmail.com
 */
public class GitUtils
{
    /**
     * @param actionEvent
     * @return
     */
    public static Project getProject(AnActionEvent actionEvent)
    {
        return (Project) actionEvent.getDataContext().getData("project");
    }

    public static GitBar getGitBar()
    {
        return ApplicationManager.getApplication().getComponent(GitBar.class);
    }
}
