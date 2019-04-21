// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.shared.simple;

import com.google.appinventor.components.common.ComponentCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jsinterop.annotations;

/**
 * Database holding property and event information of Simple components.
 *
 * @author lizlooney@google.com (lizlooney)
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
public interface ComponentDatabaseInterface {

  /**
   * Simple component information: component name, its properties
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class ComponentDefinition {
    private final String name;
    private final int version;
    private final String versionName;
    private final String dateBuilt;
    private final String type;
    private final boolean external;
    private final String categoryString;
    private final String helpString;
    private final String helpUrl;
    private final boolean showOnPalette;
    private final String categoryDocUrlString;
    private final List<PropertyDefinition> properties;
    private final List<BlockPropertyDefinition> blockProperties;
    private final List<EventDefinition> events;
    private final List<MethodDefinition> methods;
    private final Map<String, String> propertiesTypesByName;
    private final boolean nonVisible;
    private final String iconName;
    private final String typeDescription;

    @JsOverlay
    public ComponentDefinition(String name, int version, String versionName, String dateBuilt, String type, boolean external,
              String categoryString, String helpString, String helpUrl,
              boolean showOnPalette, boolean nonVisible, String iconName, String typeDescription) {
      this.name = name;
      this.version = version;
      this.versionName = versionName;
      this.dateBuilt = dateBuilt;
      this.type = type;
      this.external = external;
      this.categoryString = categoryString;
      this.helpString = helpString;
      this.helpUrl = helpUrl;
      this.showOnPalette = showOnPalette;
      this.categoryDocUrlString = ComponentCategory.valueOf(categoryString).getDocName();
      this.properties = new ArrayList<PropertyDefinition>();
      this.blockProperties = new ArrayList<BlockPropertyDefinition>();
      this.events = new ArrayList<EventDefinition>();
      this.methods = new ArrayList<MethodDefinition>();
      this.propertiesTypesByName = new HashMap<String, String>();
      this.nonVisible = nonVisible;
      this.iconName = iconName;
      this.typeDescription = typeDescription;
    }

    @JsOverlay
    public void add(PropertyDefinition property) {
      properties.add(property);
      propertiesTypesByName.put(property.getName(), property.getEditorType());
    }

    @JsOverlay
    public void add(BlockPropertyDefinition blockProperty) {
      blockProperties.add(blockProperty);
    }

    @JsOverlay
    public void add(EventDefinition event) {
      events.add(event);
    }

    @JsOverlay
    public void add(MethodDefinition method) {
      methods.add(method);
    }

    @JsOverlay
    public String getName() {
      return name;
    }

    @JsOverlay
    public int getVersion() {
      return version;
    }

    @JsOverlay
    public String getVersionName() {
      return versionName;
    }

    @JsOverlay
    public String getDateBuilt() {
      return dateBuilt;
    }

    @JsOverlay
    public String getType() {
      return type;
    }

    @JsOverlay
    public boolean isExternal() {
      return external;
    }

    @JsOverlay
    public String getCategoryString() {
      return categoryString;
    }

    @JsOverlay
    public String getHelpString() {
      return helpString;
    }

    @JsOverlay
    public String getHelpUrl() { return helpUrl; }

    @JsOverlay
    public boolean isShowOnPalette() {
      return showOnPalette;
    }

    @JsOverlay
    public String getCategoryDocUrlString() {
      return categoryDocUrlString;
    }

    @JsOverlay
    public List<PropertyDefinition> getProperties() {
      return properties;
    }

    @JsOverlay
    public List<BlockPropertyDefinition> getBlockProperties() {
      return blockProperties;
    }

    @JsOverlay
    public List<EventDefinition> getEvents() {
      return events;
    }

    @JsOverlay
    public List<MethodDefinition> getMethods() {
      return methods;
    }

    @JsOverlay
    public Map<String, String> getPropertiesTypesByName() {
      return propertiesTypesByName;
    }

    @JsOverlay
    public boolean isNonVisible() {
      return nonVisible;
    }

    @JsOverlay
    public String getIconName() {
      return iconName;
    }

    @JsOverlay
    public String getTypeDescription() {
      return typeDescription;
    }
  }


  /**
   * Property definition: property name, property editor type and property
   * default value.
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class PropertyDefinition {
    private final String name;
    private final String defaultValue;
    private final String caption;
    private final String editorType;
    private final String[] editorArgs;

    @JsOverlay
    public PropertyDefinition(String name, String defaultValue, String editorType, String[] editorArgs) {
      this(name, defaultValue, name, editorType, editorArgs);
    }

    @JsOverlay
    public PropertyDefinition(String name, String defaultValue, String caption, String editorType, String[] editorArgs) {
      this.name = name;
      this.defaultValue = defaultValue;
      this.caption = caption;
      this.editorType = editorType;
      this.editorArgs = editorArgs;
    }

    public String getName() {
      return name;
    }

    public String getCaption() {
      return caption;
    }

    public String getDefaultValue() {
      return defaultValue;
    }

    public String getEditorType() {
      return editorType;
    }

    public String[] getEditorArgs() {
      return editorArgs;
    }
  }

  /**
   * Block Property definition: property name, property description and property
   * type and read/write permission.
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class BlockPropertyDefinition {
    private final String name;
    private final String description;
    private final String type;
    private final String rw;

    @JsOverlay
    public BlockPropertyDefinition(String name, String description, String type) {
      this(name, description, type, "read-write");
    }

    @JsOverlay
    public BlockPropertyDefinition(String name, String description,
        String type, String rw) {
      this.name = name;
      this.description = description;
      this.type = type;
      this.rw = rw;
    }

    @JsOverlay
    public String getName() {
      return name;
    }

    @JsOverlay
    public String getDescription() {
      return description;
    }

    @JsOverlay
    public String getType() {
      return type;
    }

    @JsOverlay
    public String getRW() {
      return rw;
    }
  }

  /**
   * Method and Event's parameter definition: parameter name and
   * parameter type.
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class ParameterDefinition {
    private final String name;
    private final String type;

    @JsOverlay
    public ParameterDefinition(String name, String type) {
      this.name = name;
      this.type = type;
    }

    @JsOverlay
    public String getName() {
      return name;
    }

    @JsOverlay
    public String getType() {
      return type;
    }
  }

  /**
   * Event definition: event name, event description and event params.
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class EventDefinition {
    private final String name;
    private final String description;
    private final boolean deprecated;
    // "params": [{ "name": "xAccel", "type": "number"},*]
    private final List<ParameterDefinition> params;

    @JsOverlay
    public EventDefinition(String name, String description, boolean deprecated,
        List<ParameterDefinition> params) {
      this.name = name;
      this.description = description;
      this.deprecated = deprecated;
      this.params = params;
    }

    @JsOverlay
    public String getName() {
      return name;
    }

    @JsOverlay
    public String getDescription() {
      return description;
    }

    @JsOverlay
    public boolean getDeprecated() { return deprecated; }

    @JsOverlay
    public List<ParameterDefinition> getParam() {
      return params;
    }
  }

  /**
   * Method definition: method name, method description, method params,
   * and return type.
   */
   @JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "Object")
  public static class MethodDefinition {
    private final String name;
    private final String description;
    private final boolean deprecated;
    // "params": [{ "name": "xAccel", "type": "number"},*]
    private List<ParameterDefinition> params;

    @JsOverlay
    public MethodDefinition(String name, String description, boolean deprecated,
        List<ParameterDefinition> params) {
      this.name = name;
      this.description = description;
      this.deprecated = deprecated;
      this.params = params;
    }

    @JsOverlay
    public String getName() {
      return name;
    }

    @JsOverlay
    public String getDescription() {
      return description;
    }

    @JsOverlay
    public boolean getDeprecated() { return deprecated; }

    @JsOverlay
    public List<ParameterDefinition> getParam() {
      return params;
    }
  }

  /**
   * Returns the component names.
   */
  @JsOverlay
  Set<String> getComponentNames();

  /**
   *Returns the type of a component
   *
   *@param componentName name of component to query
   *@return type of the component
   */
  @JsOverlay
  String getComponentType(String componentName);

  /**
   *Returns the name of a component
   *
   *@param componentType type of component to query
   *@return name of the component
   */
  @JsOverlay
  String getComponentName(String componentType);

  /**
   *
   *Returns the whether a component is external or not
   *
   *@param componentName name of component to query
   *@return true if componentName is external false otherwise
   */
  @JsOverlay
  boolean getComponentExternal(String componentName);

  /**
   * Returns the version number of a component.
   *
   * @param componentName  name of component to query
   * @return  the component version number
   */
  @JsOverlay
  int getComponentVersion(String componentName);

  /**
   * Returns the version name of a component.
   *
   * @param componentName  name of the component to query
   * @return  the component version name, or the empty string if none is provided
   */
  @JsOverlay
  String getComponentVersionName(String componentName);

  /**
   * Returns the build date of a component.
   *
   * @param componentName  mame of the component to query
   * @return  the component build date, or the empty string if non is provided
   */
  @JsOverlay
  String getComponentBuildDate(String componentName);

  /**
   * Returns the String version of a component's category.  Note that this
   * is the result of calling getString() on a ComponentCategory, not the
   * result of calling getName().  For example, for the ComponentCategory
   * EXPERIMENTAL, this returns "EXPERIMENTAL", not "Not ready for prime
   * time".  The procedure was written this way so that the result could
   * be converted back to a ComponentCategory with valueOf().
   *
   * @param componentName  name of component to query
   * @return  the component's category
   */
  @JsOverlay
  String getCategoryString(String componentName);

  /**
   * Returns the appropriate piece of the URL in the goro docs for a
   * component's category (or null, if the mapping is not known).
   *
   * @param componentName  name of component to query
   * @return  the URL piece in the docs
   */
  @JsOverlay
  String getCategoryDocUrlString(String componentName);

  /**
   * Returns a helpful message about the component.  This message
   * originates in the <code>designerHelpDescription</code> field of the
   * component's
   * {@link com.google.appinventor.components.annotations.DesignerComponent}
   * annotation, is written to the file "simple_component.json" by
   * {@link com.google.appinventor.components.scripts.ComponentDescriptorGenerator},
   * and is read back by
   * {@link com.google.appinventor.client.editor.youngandroid.palette.YoungAndroidPalettePanel}.
   * It is not allowed to contain HTML or XML markup.
   *
   * @param componentName  name of component to query
   * @return helpful message about the component
   */
  @JsOverlay
  String getHelpString(String componentName);

  /**
   * Returns a URL to documentation for extensions.
   *
   * @param componentName  name of component to query
   * @return optional URL to external documentation for a component
   */
  @JsOverlay
  String getHelpUrl(String componentName);

  /**
   * Returns whether the component with this name should be shown on the
   * palette.  As the time this is written (2/22/10), the only component
   * that should not be shown on the palette is Form/Screen.
   *
   * @param componentName  name of component to query
   * @return whether the component should be shown on the palette
   */
  @JsOverlay
  boolean getShowOnPalette(String componentName);

  /**
   * Returns whether the component with this name is a "non-visible" component
   * (i.e., one that doesn't have a representation in the UI). Non-visible
   * components can be handled uniformly in the Designer and don't need
   * special MockComponent representations.
   *
   * @param componentName  name of component to query
   * @return whether the component is non-visible
   */
  @JsOverlay
  boolean getNonVisible(String componentName);

  /**
   * Returns the name of the icon file (last part of the path name) for the
   * icon to be shown in the Designer
   */
  @JsOverlay
  String getIconName(String componentName);

  /**
   * Returns a list of a component's property definitions.
   *
   * @param componentName  name of component to query
   * @return  list of property definition for the component
   */
  @JsOverlay
  List<PropertyDefinition> getPropertyDefinitions(String componentName);

  /**
   * Returns a list of a component's block property definitions.
   *
   * @param componentName  name of component to query
   * @return  list of block property definition for the component
   */
  @JsOverlay
  List<BlockPropertyDefinition> getBlockPropertyDefinitions(String componentName);

  /**
   * Returns a list of a component's event definitions.
   *
   * @param componentName  name of component to query
   * @return  list of event definition for the component
   */
  @JsOverlay
  List<EventDefinition> getEventDefinitions(String componentName);

  /**
   * Returns a list of a component's method definitions.
   *
   * @param componentName  name of component to query
   * @return  list of method definition for the component
   */
  @JsOverlay
  List<MethodDefinition> getMethodDefinitions(String componentName);

  /*
   * Returns a map of the property names and types for a component
   *
   * @param componentName  name of component to query
   * @return  map of property names and types
   */
  @JsOverlay
  Map<String, String> getPropertyTypesByName(String componentName);

  /*
   * Returns the JSON string describing the component type for a component
   *
   * @param componentName  name of component to query
   */
  @JsOverlay
  String getTypeDescription(String componentName);

   /*
   * Returns true if componentName matches some component
   *
   * @param componentName  name of component to query
   */
  @JsOverlay
  boolean isComponent(String componentName);
}
