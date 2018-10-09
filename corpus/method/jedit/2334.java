/*
		Override this method if you want to customize how the node dumps
		out its children.
	*/
public void dump(String prefix) {
    System.out.println(toString(prefix));
    if (children != null) {
        for (int i = 0; i < children.length; ++i) {
            SimpleNode n = (SimpleNode) children[i];
            if (n != null) {
                n.dump(prefix + " ");
            }
        }
    }
}