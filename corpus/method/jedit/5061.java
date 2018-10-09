//{{{ init() method
public void init() {
    if (providerCode == null)
        return;
    if (provider == null) {
        Object obj = BeanShell.eval(null, BeanShell.getNameSpace(), providerCode);
        provider = (DynamicMenuProvider) obj;
    }
    if (provider == null) {
        // error
        providerCode = null;
        return;
    }
    if (ebStub.menuOutOfDate || provider.updateEveryTime()) {
        ebStub.menuOutOfDate = false;
        while (getMenuComponentCount() != initialComponentCount) remove(getMenuComponentCount() - 1);
        if (provider != null)
            provider.update(this);
    }
}