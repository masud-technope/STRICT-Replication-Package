/**
		 * Find the first branch compatible with the running jEdit release.
		 */
Branch getCompatibleBranch() {
    for (Branch branch : branches) {
        if (branch.canSatisfyDependencies())
            return branch;
    }
    return null;
}