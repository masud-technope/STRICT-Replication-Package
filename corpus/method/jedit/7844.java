private boolean selectPane(OptionGroup node, String name, ArrayList<Object> path) {
    path.add(node);
    Enumeration<Object> e = node.getMembers();
    while (e.hasMoreElements()) {
        Object obj = e.nextElement();
        if (obj instanceof OptionGroup) {
            OptionGroup grp = (OptionGroup) obj;
            if (grp.getName().equals(name)) {
                path.add(grp);
                path.add(grp.getMember(0));
                TreePath treePath = new TreePath(path.toArray());
                if (treePath != null) {
                    paneTree.scrollPathToVisible(treePath);
                    paneTree.setSelectionPath(treePath);
                    return true;
                }
            } else if (selectPane((OptionGroup) obj, name, path)) {
                return true;
            }
        } else if (obj instanceof OptionPane) {
            OptionPane pane = (OptionPane) obj;
            if (pane.getName().equals(name) || name == null) {
                path.add(pane);
                TreePath treePath = new TreePath(path.toArray());
                paneTree.scrollPathToVisible(treePath);
                paneTree.setSelectionPath(treePath);
                return true;
            }
        } else if (obj instanceof String) {
            String pane = (String) obj;
            if (pane.equals(name) || name == null) {
                path.add(pane);
                TreePath treePath = new TreePath(path.toArray());
                paneTree.scrollPathToVisible(treePath);
                try {
                    paneTree.setSelectionPath(treePath);
                } catch (NullPointerException npe) {
                }
                return true;
            }
        }
    }
    path.remove(node);
    return false;
}