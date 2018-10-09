/**
		Add the specified BshClassPath as a component of our path.
		Changes in the bcp will be reflected through us.
	*/
public void addComponent(BshClassPath bcp) {
    if (compPaths == null)
        compPaths = new ArrayList();
    compPaths.add(bcp);
    bcp.addListener(this);
}