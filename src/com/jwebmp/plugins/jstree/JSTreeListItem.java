package com.jwebmp.plugins.jstree;

import com.jwebmp.base.html.Link;
import com.jwebmp.base.html.ListItem;
import com.jwebmp.plugins.jstree.enumerations.JSTreeAttributes;
import com.jwebmp.plugins.jstree.interfaces.IJSTreeListItem;
import com.jwebmp.plugins.jstree.interfaces.JSTreeChildren;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import javax.validation.constraints.NotNull;

public class JSTreeListItem<J extends JSTreeListItem<J>>
		extends ListItem<J>
		implements JSTreeChildren, com.jwebmp.plugins.jstree.interfaces.IJSTreeListItem<J>
{
	private Link<?> link;
	private boolean asRoot;
	private boolean asLink;
	private JSTreeNodeOptions<?> options;

	public JSTreeListItem()
	{
		this(null);
	}

	public JSTreeListItem(String text)
	{
		super(text);
	}

	/**
	 * Returns the link for the node
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Link<?> getLink()
	{
		return link;
	}

	/**
	 * Adds a new expansion on the child list
	 *
	 * @return
	 */
	@Override
	public JSTreeList<? extends JSTreeList> asRoot()
	{
		asRoot = true;
		JSTreeList<?> childList = new JSTreeList<>();
		childList.setRenderIDAttibute(false);
		add(childList);
		return childList;
	}

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J asLink(boolean asLink)
	{
		this.asLink = asLink;
		return (J) this;
	}

	@Override
	public void preConfigure()
	{

		if (!isConfigured() && options != null)
		{
			if (asLink)
			{
				link = new Link<>();
				link.addAttribute(JSTreeAttributes.Data_JsTree.toString(), options.toString(true));
				add(link);
			}
			else
			{
				addAttribute(JSTreeAttributes.Data_JsTree.toString(), options.toString(true));
			}
		}

		super.preConfigure();
	}

	@Override
	public JSTreeNodeOptions<? extends JSTreeNodeOptions<?>> getOptions()
	{
		setOptions(new JSTreeNodeOptions<>());
		return options;
	}

	@Override
	public void setOptions(JSTreeNodeOptions<?> options)
	{
		this.options = options;
	}

	/**
	 * Returns a cleaner version of myself
	 *
	 * @return
	 */
	public IJSTreeListItem<J> asMe()
	{
		return this;
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
