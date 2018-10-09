//}}}
//{{{ setDelegated() method
public void setDelegated(E delegated) {
    if (this.delegated != null)
        this.delegated.removeTableModelListener(this);
    delegated.addTableModelListener(this);
    this.delegated = delegated;
    fireTableStructureChanged();
}