public class Main {
    public static void main(String[] args) {

        SmoothiesBuilderPattern lactoseFreeSmoothie = Smoothies.build330LactoseFreeSmoothie();

        SmoothiesBuilderPattern sweetSmoothie = Smoothies.build750SweetSmoothie();

        SmoothiesBuilderPattern freshSmoothie = Smoothies.build330FreshSmoothie();

        SmoothiesBuilderPattern[] smoothies = new SmoothiesBuilderPattern[]{
                freshSmoothie,
                sweetSmoothie,
                lactoseFreeSmoothie};

        for(SmoothiesBuilderPattern smoothie : smoothies){
            System.out.println(smoothie);
        }
    }
}
