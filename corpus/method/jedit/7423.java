//}}}
//{{{ canImport() methods
@Override
public boolean canImport(TransferSupport support) {
    if (dragSource != null)
        return true;
    else {
        support.setDropAction(COPY);
        return super.canImport(support);
    }
}