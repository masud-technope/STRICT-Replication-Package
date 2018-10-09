// Private methods
private PropertyDescriptor[] getPropertyDescriptors() throws IntrospectionException {
    BeanInfo _info = Introspector.getBeanInfo(getClass());
    return _info.getPropertyDescriptors();
}