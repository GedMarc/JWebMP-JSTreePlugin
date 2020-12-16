package com.jwebmp.plugins.jstree;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.core.base.html.ListItem;
import com.jwebmp.core.base.html.interfaces.children.ListItemChildren;
import com.jwebmp.plugins.jstree.enumerations.JSTreeAttributes;
import com.jwebmp.plugins.jstree.interfaces.IJSTreeListItem;
import com.jwebmp.plugins.jstree.interfaces.JSTreeChildren;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import jakarta.validation.constraints.NotNull;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_EMPTY;
import static com.jwebmp.core.utilities.StaticStrings.*;

public class JSTreeListItem<J extends JSTreeListItem<J>>
		extends ListItem<J>
		implements JSTreeChildren, com.jwebmp.plugins.jstree.interfaces.IJSTreeListItem<J>
{
	private Link<?> link;
	private boolean asParent;
	private boolean asLink;
	private JSTreeNodeOptions<?> options;
	private JSTreeList<?> childItems;

	public JSTreeListItem()
	{
		this(null);
	}

	public JSTreeListItem(String text)
	{
		super(text);
	}

	public JSTreeListItem(String text, JSTreeNodeOptions<?> options)
	{
		this(text);
		this.options = options;
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
	public JSTreeList<? extends JSTreeList<?>> asParent()
	{
		asParent = true;
		if (childItems == null)
		{
			childItems = new JSTreeList<>();
		}
		return childItems;
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
	public JSTreeNodeOptions<? extends JSTreeNodeOptions<?>> getOptions()
	{
		if (options == null)
		{
			setOptions(new JSTreeNodeOptions<>());
		}
		return options;
	}

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setOptions(JSTreeNodeOptions<?> options)
	{
		this.options = options;
		return (J) this;
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

	@SuppressWarnings("unchecked")
	@NotNull
	public J setAsParent(boolean asParent)
	{
		this.asParent = asParent;
		return (J) this;
	}

	@SuppressWarnings("unchecked")
	@NotNull
	public J setAsLink(boolean asLink)
	{
		this.asLink = asLink;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	/**
	 * Method add ...
	 *
	 * @param newChild
	 * 		of type ListItemChildren
	 *
	 * @return J
	 */
	@SuppressWarnings("unchecked")
	public @NotNull J add(@NotNull JSTreeListItem<?> newChild)
	{
		asParent = true;
		getChildItems().add(newChild);
		return (J) this;
	}

	public JSTreeList<?> getChildItems()
	{
		if (childItems == null)
		{
			childItems = new JSTreeList<>();
			add(childItems);
		}
		return childItems;
	}

	@Override
	public void preConfigure()
	{
		String dataValue = options == null ? STRING_EMPTY : options.toString(true);
		if (asLink)
		{
			link = new Link<>();
			if (!dataValue.isEmpty())
			{
				link.addAttribute(JSTreeAttributes.Data_JsTree.toString(), dataValue);
			}
			add(link);
		}
		else
		{
			if (!dataValue.isEmpty())
			{
				addAttribute(JSTreeAttributes.Data_JsTree.toString(), dataValue);
			}
			setInvertColonRender(true);
		}
		super.preConfigure();
	}
}
