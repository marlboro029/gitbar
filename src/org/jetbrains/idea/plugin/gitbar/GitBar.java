package org.jetbrains.idea.plugin.gitbar;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.AbstractVcs;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import org.jetbrains.annotations.NotNull;

import java.util.ResourceBundle;

/**
 * @author marlboro027@foxmail.com
 */
public class GitBar implements ApplicationComponent
{
    public static final ResourceBundle BUNDLE = ResourceBundle.getBundle("org/jetbrains/idea/plugin/gitbar/resource/action-map");

    public GitBar()
    {
    }

    @Override
    public void initComponent()
    {
    }

    @Override
    public void disposeComponent()
    {
    }

    @Override
    @NotNull
    public String getComponentName()
    {
        return "GitBar";
    }


    public boolean isVisible(final Project project)
    {
        return isGit(project);
    }

    private boolean isGit(final Project project)
    {
        if (project == null)
        {
            return false;
        }
        final ProjectLevelVcsManager vcsManager = ProjectLevelVcsManager.getInstance(project);
        if (vcsManager == null)
        {
            return false;
        }
        final AbstractVcs abstractVcss[] = vcsManager.getAllActiveVcss();
        if (abstractVcss == null)
        {
            return false;
        }

        for (AbstractVcs vcs : abstractVcss)
        {
            if ("GIT".equalsIgnoreCase(vcs.getName()))
            {
                return true;
            }
        }
        return false;
    }
}
