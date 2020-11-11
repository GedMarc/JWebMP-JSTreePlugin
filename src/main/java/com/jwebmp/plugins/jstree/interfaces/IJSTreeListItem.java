package com.jwebmp.plugins.jstree.interfaces;

import com.jwebmp.core.base.html.Link;
import com.jwebmp.plugins.jstree.JSTreeList;
import com.jwebmp.plugins.jstree.JSTreeListItem;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;

import jakarta.validation.constraints.NotNull;

public interface IJSTreeListItem<J extends JSTreeListItem<J>>
{
	/**
	 * Returns the link for the node
	 *
	 * @return
	 */
	@NotNull
	Link<?> getLink();

	/**
	 * Adds a new expansion on the child list
	 *
	 * @return
	 */
	JSTreeList<? extends JSTreeList> asParent();

	@SuppressWarnings("unchecked")
	@NotNull
	J asLink(boolean asLink);

	JSTreeNodeOptions<? extends JSTreeNodeOptions<?>> getOptions();

	J setOptions(JSTreeNodeOptions<?> options);
}
