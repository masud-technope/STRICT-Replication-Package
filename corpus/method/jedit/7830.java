/** Performs doMigrate() on each installed
		OneTimeMigrationService */
public static void execute() {
    String[] migrations = ServiceManager.getServiceNames(OneTimeMigrationService.class);
    if (migrations.length == 0)
        return;
    for (String migration : migrations) {
        Object obj = ServiceManager.getService(OneTimeMigrationService.class, migration);
        OneTimeMigrationService svc = (OneTimeMigrationService) obj;
        svc.doMigration();
    }
}