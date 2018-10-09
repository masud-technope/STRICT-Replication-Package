/** Calls migrate() but only once per installation. */
public void doMigration() {
    if (!jEdit.getBooleanProperty("migration.step." + name)) {
        Log.log(Log.MESSAGE, this, "Performing migration step: " + name);
        migrate();
        jEdit.setBooleanProperty("migration.step." + name, true);
    }
}