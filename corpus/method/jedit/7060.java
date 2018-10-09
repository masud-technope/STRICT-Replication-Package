@Override
public void actionPerformed(ActionEvent evt) {
    if (focusedComponent != null)
        focusedComponent.updateStructureHighlight();
}