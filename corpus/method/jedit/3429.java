@Override
public void componentRemoved(ContainerEvent evt) {
    componentRemoved(evt.getChild());
}