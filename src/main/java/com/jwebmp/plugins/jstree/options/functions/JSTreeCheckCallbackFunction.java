/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jstree.options.functions;

import com.jwebmp.core.htmlbuilder.javascript.JavascriptLiteralFunction;
import com.jwebmp.core.plugins.ComponentInformation;

import javax.validation.constraints.NotNull;

/**
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
@ComponentInformation(name = "JS Tree Callback Plugin",
		description = "This plugin overrides the activate_node function (the one that gets called when a user tries to select a node) and enables preventing the function invokation by using a callback.",
		url = "https://www.jstree.com/plugins/")
public class JSTreeCheckCallbackFunction<J extends JSTreeCheckCallbackFunction<J>>
		extends JavascriptLiteralFunction<J>
{

	public static final String CreateNode = "create_node";
	public static final String RenameNode = "rename_node";
	public static final String DeleteNode = "delete_node";
	public static final String MoveNode = "move_node";
	public static final String CopyNode = "copy_node";
	private static final String IfOperationString = "if(operation === '";
	private static final String EndIfOperationString = "') return true;";
	private static final long serialVersionUID = 1L;

	private Boolean create;
	private Boolean rename;
	private Boolean delete;
	private Boolean move;
	private Boolean copy;

	public JSTreeCheckCallbackFunction()
	{
		getFunctionArugments().add("operation");
		getFunctionArugments().add("node");
		getFunctionArugments().add("node_parent");
		getFunctionArugments().add("node_position");
		getFunctionArugments().add("more");
	}

	@Override
	public StringBuilder getLiteralFunction()
	{
		StringBuilder function = new StringBuilder();
		if (create != null && create)
		{
			function.append(IfOperationString + CreateNode + EndIfOperationString);
		}
		if (rename != null && rename)
		{
			function.append(IfOperationString + RenameNode + EndIfOperationString);
		}
		if (delete != null && delete)
		{
			function.append(IfOperationString + DeleteNode + EndIfOperationString);
		}
		if (move != null && move)
		{
			function.append(IfOperationString + MoveNode + EndIfOperationString);
		}
		if (copy != null && copy)
		{
			function.append(IfOperationString + CopyNode + EndIfOperationString);
		}
		function.append("return false;");
		return function;
	}

	/**
	 * Whether or not create is allowed
	 *
	 * @return
	 */
	public Boolean getCreate()
	{
		return create;
	}

	/**
	 * Whether or not create is allowed
	 *
	 * @param create
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCreate(Boolean create)
	{
		this.create = create;
		return (J) this;
	}

	/**
	 * If rename is allowed
	 *
	 * @return
	 */
	public Boolean getRename()
	{
		return rename;
	}

	/**
	 * If rename is allowed
	 *
	 * @param rename
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRename(Boolean rename)
	{
		this.rename = rename;
		return (J) this;
	}

	/**
	 * If delete is allowed
	 *
	 * @return
	 */
	public Boolean getDelete()
	{
		return delete;
	}

	/**
	 * if delete is allowed
	 *
	 * @param delete
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDelete(Boolean delete)
	{
		this.delete = delete;
		return (J) this;
	}

	/**
	 * if move is allowed
	 *
	 * @return
	 */
	public Boolean getMove()
	{
		return move;
	}

	/**
	 * if move is allowed
	 *
	 * @param move
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMove(Boolean move)
	{
		this.move = move;
		return (J) this;
	}

	/**
	 * if copy is allowed
	 *
	 * @return
	 */
	public Boolean getCopy()
	{
		return copy;
	}

	/**
	 * If copy is allowed
	 *
	 * @param copy
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCopy(Boolean copy)
	{
		this.copy = copy;
		return (J) this;
	}

}
