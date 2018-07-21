package com.jwebmp.plugins.jstree.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import javax.validation.constraints.NotNull;

public class JSTreeNodeOptions<J extends JSTreeNodeOptions<J>>
		extends JavaScriptPart<J>
{
	private String icon;

	private boolean selected;

	private boolean opened;

	private boolean disabled;

	public JSTreeNodeOptions()
	{
		//No config required
	}

	/**
	 * Gets the icon for the node
	 *
	 * @return
	 */
	public String getIcon()
	{
		return icon;
	}

	/**
	 * Sets the icon of the node, string url // or class name (fa fa-bla)
	 *
	 * @param icon
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setIcon(String icon)
	{
		this.icon = icon;
		return (J) this;
	}

	/**
	 * Opens if the node is selected
	 *
	 * @return
	 */
	public boolean isSelected()
	{
		return selected;
	}

	/**
	 * Sets if the node is selected
	 *
	 * @param selected
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSelected(boolean selected)
	{
		this.selected = selected;
		return (J) this;
	}

	/**
	 * If the node is opened
	 *
	 * @return
	 */
	public boolean isOpened()
	{
		return opened;
	}

	/**
	 * Sets the node opened
	 *
	 * @param opened
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOpened(boolean opened)
	{
		this.opened = opened;
		return (J) this;
	}

	/**
	 * If the node is disabled
	 *
	 * @return
	 */
	public boolean isDisabled()
	{
		return disabled;
	}

	/**
	 * Sets the node disabled
	 *
	 * @param disabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDisabled(boolean disabled)
	{
		this.disabled = disabled;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}
