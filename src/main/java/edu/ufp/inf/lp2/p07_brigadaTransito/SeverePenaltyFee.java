package edu.ufp.inf.lp2.p07_brigadaTransito;

public class SeverePenaltyFee extends PenaltyFee{
    private static final String PARKING_VIOLATION = "PARKING_VIOLATION";

    private static final String PROHIBITION_ON_OVERTAKING = "PROHIBITION_ON_OVERTAKING";

    @Override
    public float value() {
        return 2*PenaltyFee.MIN_VALUE + 2 * super.geDriver().getNumPenalties();
    }

    @Override
    public float punishment() {
        return 0;
    }
}
