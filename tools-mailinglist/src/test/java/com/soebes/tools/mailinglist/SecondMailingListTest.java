package com.soebes.tools.mailinglist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondMailingListTest
{
    // Oct, Nov, Dec
    // Jul, Aug, Sep
    // Apr, May, Jun
    // Jan, Feb, Mar

    private Map<String, Integer> monthly;
    private Map<String, Integer> summ;
    
    private WebTester webTester;

    @BeforeMethod
    public void beforeMethod()
    {
        webTester = new WebTester();
        webTester.setTestingEngineKey( TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT );
        webTester.setBaseUrl( "http://mail-archives.apache.org/" );
        
        monthly = new HashMap<String, Integer>();
        summ = new HashMap<String, Integer>();
    }

    @Test
    public void firstTest()
    {
        webTester.beginAt( "/mod_mbox/maven-users/200211.mbox/" );
        IElement elementByXPath = webTester.getElementByXPath( "/html/body/table[@id='boxlist']/tbody" );
        
        List<IElement> elementsByXPath = elementByXPath.getElements( "./tr" );
        for ( IElement iElement : elementsByXPath )
        {
            IElement time = iElement.getElement( "./td[@class='box']/a");
            IElement msgCount = iElement.getElement( "./td[@class='msgcount']" );
            System.out.println(time.getTextContent() + " count:" + msgCount.getTextContent());
            monthly.put( time.getTextContent().trim(), Integer.parseInt( msgCount.getTextContent().trim() ));
        }
        
        // Year, Quarter, Sum
        for ( Entry<String, Integer> item : monthly.entrySet() )
        {
            String[] split = item.getKey().split( " " );
            // Month split[0]
            // Year split[1]
            
//            String quarter = calculateQuarter(split[0]);
        }
    }

}
