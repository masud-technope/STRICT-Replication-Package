boolean canSatisfyDependencies() {
    for (Dependency dep : deps) {
        if (!dep.canSatisfy())
            return false;
    }
    return true;
}