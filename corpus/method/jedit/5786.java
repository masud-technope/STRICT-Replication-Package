void satisfyDependencies(Roster roster, String installDirectory, boolean downloadSource) {
    for (Dependency dep : deps) dep.satisfy(roster, installDirectory, downloadSource);
}