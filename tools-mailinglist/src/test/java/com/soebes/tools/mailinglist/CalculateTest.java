package com.soebes.tools.mailinglist;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculateTest
{

    @DataProvider(name = "createMonths")
    public Object[][] createMonths() {
        return new Object[][] {
            { "Jan", "Jan-Mar" },
            { "Feb", "Jan-Mar" },
            { "Mar", "Jan-Mar" },
            { "Apr", "Apr-Jun" },
            { "May", "Apr-Jun" },
            { "Jun", "Apr-Jun" },
            { "Jul", "Jul-Sep" },
            { "Aug", "Jul-Sep" },
            { "Sep", "Jul-Sep" },
            { "Oct", "Oct-Dec" },
            { "Nov", "Oct-Dec" },
            { "Dec", "Oct-Dec" },
        };
    }
    @Test(dataProvider = "createMonths")
    public void shouldReturnQuarterForEveryMoth(String month, String expectedValue)
    {
        String result = calculateQuerter( month );
        assertThat( result ).isEqualTo( expectedValue );
    }
    
    
    @Test( expectedExceptions = { IllegalArgumentException.class } )
    public void shouldReturnIllegalArgumentException()
    {
        calculateQuerter( "XXX" );
    }

    public String calculateQuerter( String month )
    {
        if ( "Jan".equals( month ) || "Feb".equals( month ) || "Mar".equals( month ) )
        {
            return "Jan-Mar";
        }
        else if ( "Apr".equals( month ) || "May".equals( month ) || "Jun".equals( month ) )
        {
            return "Apr-Jun";
        }
        else if ( "Jul".equals( month ) || "Aug".equals( month ) || "Sep".equals( month ) )
        {
            return "Jul-Sep";
        }
        else if ( "Oct".equals( month ) || "Nov".equals( month ) || "Dec".equals( month ) )
        {
            return "Oct-Dec";
        }
        else
        {
            throw new IllegalArgumentException( "Invalid month given" );
        }
    }
}
