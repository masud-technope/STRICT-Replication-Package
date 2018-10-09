//}}}
//{{{ propertiesChanged() method
/**
	 * Reinitializes the textarea by reading the properties from the property manager
	 */
@Override
public void propertiesChanged() {
    getInputHandler().removeAllKeyBindings();
    JEditActionSet<JEditBeanShellAction>[] actionSets = getActionContext().getActionSets();
    for (JEditActionSet<JEditBeanShellAction> actionSet : actionSets) {
        actionSet.initKeyBindings();
    }
    Chunk.propertiesChanged(propertyManager);
    initBuffer();
    initTextArea();
    super.propertiesChanged();
}