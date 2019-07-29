public class Type1Adjustment implements SalaryAdjust {
    double raise;

    public Type1Adjustment() {
    }

    public int adjust(double raise) {
        this.raise = raise;
        int raiseInt = (int)(raise * 100 -100);
        if(raiseInt > 10) {
            return 10;
        } else if (raiseInt < 0) {
            return 0;
        } else {
            return raiseInt;
        }
    }
}
