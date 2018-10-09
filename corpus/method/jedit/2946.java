public List<EBMessageHandler> safeGet(Class<?> type) {
    List<EBMessageHandler> lst = super.get(type);
    if (lst == null) {
        lst = new LinkedList<EBMessageHandler>();
        super.put(type, lst);
    }
    return lst;
}