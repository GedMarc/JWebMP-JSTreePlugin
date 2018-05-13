package com.jwebmp.plugins.jstree;

import com.jwebmp.base.html.Link;
import com.jwebmp.base.html.ListItem;
import com.jwebmp.plugins.jstree.enumerations.JSTreeAttributes;
import com.jwebmp.plugins.jstree.interfaces.JSTreeChildren;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import javax.validation.constraints.NotNull;

public class JSTreeListItem<J extends JSTreeListItem<J>>
		extends ListItem<J>
		implements JSTreeChildren
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
	@NotNull
	public Link<?> getLink()
	{
		return link;
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

	/**
	 * Adds a new expansion on the child list
	 *
	 * @return
	 */
	public JSTreeList<? extends JSTreeList> asRoot()
	{
		asRoot = true;
		JSTreeList<?> childList = new JSTreeList<>();
		childList.setRenderIDAttibute(false);
		add(childList);
		return childList;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J asLink(boolean asLink)
	{
		this.asLink = asLink;
		return (J) this;
	}

	@Override
	public JSTreeNodeOptions<? extends JSTreeNodeOptions<?>> getOptions()
	{
		setOptions(new JSTreeNodeOptions<>());
		return options;
	}

	public void setOptions(JSTreeNodeOptions<?> options)
	{
		this.options = options;
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
