package edu.ufp.inf.lp2.p07_brigadaTransito;

public class VerySeverePenaltyFee extends PenaltyFee{
    private static final String SPEEDING = "SPEEDING";

    private static final String DRIVING_UNDER_INFLUENCE = "DRIVING_UNDER_INFLUENCE";

    @Override
    public float value() {
        return 0;
    }

    @Override
    public float punishment() {
        return 0;
    }
}
