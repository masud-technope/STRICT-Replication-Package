private void reloadContextList(String contextMenu) {
    listModel.clear();
    StringTokenizer st = new StringTokenizer(contextMenu);
    while (st.hasMoreTokens()) {
        String actionName = st.nextToken();
        if (actionName.equals("-"))
            listModel.addElement(new AbstractContextOptionPane.MenuItem("-", "-"));
        else {
            EditAction action = actionContext.getAction(actionName);
            if (action == null)
                continue;
            String label = action.getLabel();
            if (label == null)
                continue;
            listModel.addElement(new AbstractContextOptionPane.MenuItem(actionName, label));
        }
    }
}