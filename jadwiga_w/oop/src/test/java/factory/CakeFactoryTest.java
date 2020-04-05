package factory;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CakeFactoryTest {

    @Test
    public void shouldReturnCheesecake(){
        //given
        CakeFactory cakeFactory = new CakeFactory();
        //when
        Cake cake = cakeFactory.getCake(CakeEnum.CHEESECAKE);
        //then
        assertThat(cake instanceof Cheesecake );
    }

    @Test
    public void shouldReturnApplePie(){
        //given
        CakeFactory cakeFactory = new CakeFactory();
        //when
        Cake cake = cakeFactory.getCake(CakeEnum.APPLE_PIE);
        //then
        assertThat(cake instanceof ApplePie);
    }

    @Test
    public void shouldReturnBrownie(){
        //given
        CakeFactory cakeFactory = new CakeFactory();
        //when
        Cake cake = cakeFactory.getCake(CakeEnum.BROWNIE);
        //then
        assertThat(cake instanceof Brownie);
    }

}