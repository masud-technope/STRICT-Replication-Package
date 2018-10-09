/* Determines whether the current node was actually closed and
     pushed.  This should only be called in the final user action of a
     node scope.  */
boolean nodeCreated() {
    return node_created;
}