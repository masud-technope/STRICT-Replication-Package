public void registerTransferableService(JEditTransferableService transferableService) {
    if (!services.contains(transferableService))
        services.add(transferableService);
}