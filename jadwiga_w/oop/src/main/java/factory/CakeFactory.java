package factory;

public class CakeFactory {
    public Cake getCake(CakeEnum cakeEnum) {
        switch (cakeEnum) {
            case BROWNIE: {
                return new Brownie();
            }
            case CHEESECAKE: {
                return new Cheesecake();
            }
            case APPLE_PIE: {
                return new ApplePie();
            }
            default: {
                return null;
            }
        }
    }
}