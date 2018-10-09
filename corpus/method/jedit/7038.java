//{{{ adjustmentValueChanged() method
@Override
public void adjustmentValueChanged(AdjustmentEvent evt) {
    if (!scrollBarsInitialized)
        return;
    if (evt.getAdjustable() == vertical)
        setFirstLine(vertical.getValue());
    else
        setHorizontalOffset(-horizontal.getValue());
//}}}
}