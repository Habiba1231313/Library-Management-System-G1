package adapter;

import Model.FinanceSys;

public class FinanceSysAdapter implements FinanceSystemAdapter {

    private FinanceSys finance = new FinanceSys();

    @Override
    public boolean transferDeposit(float amount) {
        return finance.transferDeposit(amount);
    }
}
