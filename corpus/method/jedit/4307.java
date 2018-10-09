//}}}
//{{{ addServiceContextMenuItems() method
/**
	 * @return a list of menu items defined by services.
	 *
	 * @param textArea the TextArea desiring to display these menu items
	 * @param evt a mouse event
	 * @since jEdit 4.3pre15
	 */
public static List<JMenuItem> getServiceContextMenuItems(JEditTextArea textArea, MouseEvent evt) {
    List<JMenuItem> list = new ArrayList<JMenuItem>();
    String serviceClassName = DynamicContextMenuService.class.getName();
    String[] menuServiceList = ServiceManager.getServiceNames(serviceClassName);
    for (String menuServiceName : menuServiceList) {
        if (menuServiceName != null && menuServiceName.trim().length() > 0) {
            DynamicContextMenuService dcms = (DynamicContextMenuService) ServiceManager.getService(serviceClassName, menuServiceName);
            if (dcms != null) {
                JMenuItem[] items = dcms.createMenu(textArea, evt);
                if (items != null) {
                    list.addAll(Arrays.asList(items));
                }
            }
        }
    }
    return list;
}