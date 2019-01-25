package com.jwebmp.plugins.jstree.options.selected;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jstree.options.JSTreeNodeStateOptions;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JSTreeNodeSelectedOptions<J extends JSTreeNodeSelectedOptions<J>>
		extends JavaScriptPart<J>
{
	private List<String> parents;
	private List<String> children;
	@JsonIgnoreProperties("childrenD")
	private List<String> childrenD;
	private JSTreeNodeStateOptions state;
	private String text;

	/**
	 * Getter for property 'parents'.
	 *
	 * @return Value for property 'parents'.
	 */
	public List<String> getParents()
	{
		return parents;
	}

	/**
	 * Setter for property 'parents'.
	 *
	 * @param parents
	 * 		Value to set for property 'parents'.
	 */
	public void setParents(List<String> parents)
	{
		this.parents = parents;
	}

	/**
	 * Getter for property 'children'.
	 *
	 * @return Value for property 'children'.
	 */
	public List<String> getChildren()
	{
		return children;
	}

	/**
	 * Setter for property 'children'.
	 *
	 * @param children
	 * 		Value to set for property 'children'.
	 */
	public void setChildren(List<String> children)
	{
		this.children = children;
	}

	/**
	 * Getter for property 'childrenD'.
	 *
	 * @return Value for property 'childrenD'.
	 */
	public List<String> getChildrenD()
	{
		return childrenD;
	}

	/**
	 * Setter for property 'childrenD'.
	 *
	 * @param childrenD
	 * 		Value to set for property 'childrenD'.
	 */
	public void setChildrenD(List<String> childrenD)
	{
		this.childrenD = childrenD;
	}

	/**
	 * Getter for property 'state'.
	 *
	 * @return Value for property 'state'.
	 */
	public JSTreeNodeStateOptions getState()
	{
		return state;
	}

	/**
	 * Setter for property 'state'.
	 *
	 * @param state
	 * 		Value to set for property 'state'.
	 */
	public void setState(JSTreeNodeStateOptions state)
	{
		this.state = state;
	}

	/**
	 * Getter for property 'text'.
	 *
	 * @return Value for property 'text'.
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Setter for property 'text'.
	 *
	 * @param text
	 * 		Value to set for property 'text'.
	 */
	public void setText(String text)
	{
		this.text = text;
	}
}
