package org.jetbrains.idea.plugin.gitbar.action;

import com.intellij.openapi.actionSystem.ActionManager;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.plugin.gitbar.GitBar;

import javax.swing.*;

/**
 * @author @author marlboro027@foxmail.com
 */
public class DefaultGitAction extends BasicProxyAction
{
    public DefaultGitAction()
    {
    }

    public DefaultGitAction(@Nullable final String text, @Nullable final String description, @Nullable final Icon icon)
    {
        super(text, description, icon);
    }

    @Override
    protected String getActionId()
    {
        final String actionId = ActionManager.getInstance().getId(this);
        return GitBar.BUNDLE.getString(actionId);
    }
}
