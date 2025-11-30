package adapter;

import Model.MembershipApplication;
import Model.UniversitySystem;

public class PearlSysAdapter implements UniversitySystemAdapter {

    private UniversitySystem uniSystem = new UniversitySystem();
    
    @Override
    public boolean verifyApplicant(MembershipApplication app) {
        return uniSystem.verifyApplicant(app);
    }

  
}
