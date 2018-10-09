boolean canBeInstalled() {
    Branch branch = getCompatibleBranch();
    return branch != null && !branch.obsolete && branch.canSatisfyDependencies();
}