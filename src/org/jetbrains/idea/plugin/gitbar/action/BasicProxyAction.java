package org.jetbrains.idea.plugin.gitbar.action;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.plugin.gitbar.GitBar;
import org.jetbrains.idea.plugin.gitbar.GitUtils;

import javax.swing.*;

/**
 * @author marlboro027@foxmail.com
 */
public abstract class BasicProxyAction extends AnAction
{
    public BasicProxyAction()
    {
    }

    public BasicProxyAction(@Nullable final String text)
    {
        super(text);
    }

    public BasicProxyAction(@Nullable final String text, @Nullable final String description, @Nullable final Icon icon)
    {
        super(text, description, icon);
    }


    protected abstract String getActionId();

    public void actionPerformed(final AnActionEvent actionEvent)
    {
        final AnAction anaction = ActionManager.getInstance().getAction(getActionId());
        if (anaction != null)
        {
            anaction.actionPerformed(actionEvent);
        }
    }

    public void update(final AnActionEvent actionEvent)
    {
        try
        {
            final AnAction anaction = ActionManager.getInstance().getAction(getActionId());
            if (anaction != null)
            {
                anaction.beforeActionPerformedUpdate(actionEvent);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        final Project project = GitUtils.getProject(actionEvent);
        final GitBar bar = GitUtils.getGitBar();
        final Presentation presentation = actionEvent.getPresentation();
        presentation.setVisible(bar.isVisible(project) && (presentation.isEnabled()));
    }
}
