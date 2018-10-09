//}}}
//{{{ getDockingFrameworkName() method
public static String getDockingFrameworkName() {
    String framework = jEdit.getProperty(VIEW_DOCKING_FRAMEWORK_PROPERTY, ORIGINAL_DOCKING_FRAMEWORK);
    return framework;
}