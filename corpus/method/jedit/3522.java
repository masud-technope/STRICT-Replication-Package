//}}}
//{{{ setDelegated() method
public void setDelegated(E delegated) {
    this.delegated.removeListDataListener(this);
    delegated.addListDataListener(this);
    this.delegated = delegated;
}