//}}}
//{{{ getLastEdit() method
private Edit getLastEdit() {
    if (undosLast instanceof CompoundEdit)
        return ((CompoundEdit) undosLast).last;
    else
        return undosLast;
}