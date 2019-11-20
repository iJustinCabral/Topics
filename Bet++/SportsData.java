
/**
 * Write a description of class SportsData here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SportsData
{
    
    private Object[][] footballData = {{"October 20th","Ravens vs. Bills","    +4 : -4", "    -115 : -105"},
                                       {"October 20th","Saints vs. Bears","    +4 : -4", "    -120 : +100"},
                                       {"October 20th","Eagles vs. Cowboys","    +3 : -3", "    -115 : -105"},
                                       {"October 20th","Rams vs. Falcons","    -3 : +3", "    -110 : +110"},
                                       {"October 21st","Patriots vs. Jets","   -10 : +10","    -105 : +105"},
                                       {"October 20th","Packers vs Jaguars", "    +10  -10","    -110 : +110"},
                                       {"October 20th","Bengals vs 49ers", "    -3 : +3", "    -105 : +105"}};
                                       
    private Object[][] baseballData = {{"October 20th","Astros vs. Oriels","    +3 : -3", "    -115 : -105"},
                                       {"October 20th","Red Sox vs. Yankees","    +1 : -1", "    -120 : +100"},
                                       {"October 20th","Cardinals vs. Rockies","    +3 : -3", "    -115 : -105"},
                                       {"October 20th","Dodgers vs. Braves","    -2 : +2", "    -110 : +110"},
                                       {"October 21st","Giants vs. DBacks","    -1 : +1","    -105 : +105"},
                                       {"October 20th","Rays vs Indians", "    +4  -4","    -110 : +110"},
                                       {"October 20th","Royals vs Twins", "    -3 : +3", "    -105 : +105"}};
                                       
    private Object[][] basketballData = {{"October 20th","Celtics vs. Bulls","    +14 : -14", "    -115 : -105"},
                                       {"October 20th","Wizards vs. Bucks","    +4 : -4", "    -120 : +100"},
                                       {"October 20th","76ers vs. Hawks","    +3 : -3", "    -115 : -105"},
                                       {"October 20th","Nets vs. Clippers","    -13 : +13", "    -110 : +110"},
                                       {"October 21st","Lakers vs. Suns","    -10 : +10","    -105 : +105"},
                                       {"October 20th","Rockets vs Jazz", "    +10  -10","    -110 : +110"},
                                       {"October 10th","Grizzlies vs Knicks", "    -3 : +3", "    -105 : +105"}};
                                       
    private Object[][] hockeyData = {{"October 20th","Flyers vs. Rangers","    +1 : -1", "    -115 : -105"},
                                       {"October 20th","Oilers vs. Flames","    +2 : -2", "    -120 : +100"},
                                       {"October 20th","Leafs vs. Devils","    +1 : -1", "    -115 : -105"},
                                       {"October 20th","Devils vs. Red Wings","    -3 : +3", "    -110 : +110"},
                                       {"October 21st","Bruins vs. Sharks","    -1 : +1","    -105 : +105"},
                                       {"October 20th","Kings vs Canucks", "    +1  -1","    -110 : +110"},
                                       {"October 10th","Ducks vs Stars", "    -3 : +3", "    -105 : +105"}};
    
    public SportsData(){}
    
    public Object[][] getFootballData() {
        return this.footballData;
    }
    
    public Object[][] getBasketballData() {
        return this.basketballData;
    }
    
    public Object[][] getBaseballData() {
        return this.baseballData;
    }
    
    public Object[][] getHockeyData() {
        return this.hockeyData;
    }
    

}
