public void addConfiguredJavaProperty(JavaProperty javaProperty) throws BuildException {
    String name = javaProperty.getName();
    String value = javaProperty.getValue();
    if ((name == null) || (value == null))
        throw new BuildException("'<javaproperty>' must have both 'name' and 'value' attibutes");
    bundleProperties.addJavaProperty(name, value);
}