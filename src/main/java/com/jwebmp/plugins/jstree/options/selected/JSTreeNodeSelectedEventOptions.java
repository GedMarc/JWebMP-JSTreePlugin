package com.jwebmp.plugins.jstree.options.selected;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

public class JSTreeNodeSelectedEventOptions<J extends JSTreeNodeSelectedEventOptions<J>>
		extends JavaScriptPart<J>
{
	private JSTreeNodeSelectedOptions<?> selected;

	public JSTreeNodeSelectedOptions<?> getSelected()
	{
		return selected;
	}

	public void setSelected(JSTreeNodeSelectedOptions<?> selected)
	{
		this.selected = selected;
	}
}
