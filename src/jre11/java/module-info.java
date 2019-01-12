import com.jwebmp.core.base.angular.services.IAngularDirective;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.plugins.jstree.JSTreePageConfigurator;
import com.jwebmp.plugins.jstree.events.onchangedevent.JSTreeOnChangedPluginDirective;
import com.jwebmp.plugins.jstree.events.onselectedevent.JSTreeOnSelectDirective;

module com.jwebmp.plugins.jstree {

	exports com.jwebmp.plugins.jstree;
	exports com.jwebmp.plugins.jstree.features;

	exports com.jwebmp.plugins.jstree.events.onchangedevent;
	exports com.jwebmp.plugins.jstree.events.onselectedevent;


	exports com.jwebmp.plugins.jstree.enumerations;
	exports com.jwebmp.plugins.jstree.interfaces;
	exports com.jwebmp.plugins.jstree.options;
	exports com.jwebmp.plugins.jstree.options.selected;
	exports com.jwebmp.plugins.jstree.themes;

	requires com.jwebmp.core;
	requires com.jwebmp.logmaster;
	requires com.jwebmp.guicedservlets;
	requires com.fasterxml.jackson.annotation;

	requires java.validation;
	requires java.logging;
	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.core.angularjs;

	provides IPageConfigurator with JSTreePageConfigurator;
	provides IAngularDirective with JSTreeOnChangedPluginDirective, JSTreeOnSelectDirective;

	provides IGuiceScanJarExclusions with com.jwebmp.plugins.jstree.implementations.JSTreeExclusionsModule;
	provides IGuiceScanModuleExclusions with com.jwebmp.plugins.jstree.implementations.JSTreeExclusionsModule;

	opens com.jwebmp.plugins.jstree to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jstree.events.onchangedevent to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.jstree.events.onselectedevent to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	//	opens com.jwebmp.plugins.jstree.events to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jstree.interfaces to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jstree.features to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
	opens com.jwebmp.plugins.jstree.options to com.fasterxml.jackson.databind, com.jwebmp.core;

	opens com.jwebmp.plugins.jstree.options.selected to com.fasterxml.jackson.databind, com.jwebmp.core;

	opens com.jwebmp.plugins.jstree.options.enumerations to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jstree.options.functions to com.fasterxml.jackson.databind, com.jwebmp.core;
	opens com.jwebmp.plugins.jstree.themes to com.fasterxml.jackson.databind, com.jwebmp.core;


}
