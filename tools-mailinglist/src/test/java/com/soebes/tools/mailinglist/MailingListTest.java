package com.soebes.tools.mailinglist;

import java.util.List;

import net.sourceforge.jwebunit.api.IElement;
import net.sourceforge.jwebunit.junit.WebTester;
import net.sourceforge.jwebunit.util.TestingEngineRegistry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MailingListTest
{
    private WebTester webTester;

    @BeforeMethod
    public void beforeMethod()
    {
        webTester = new WebTester();
        webTester.setTestingEngineKey( TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT );
        webTester.setBaseUrl( "http://mail-archives.apache.org/mod_mbox/maven-users" );
    }

    @Test
    public void firstTest()
    {
        webTester.beginAt( "/" );
        List<IElement> elementsByXPath = webTester.getElementsByXPath( "//table[@class='year']" );
        for ( IElement iElement : elementsByXPath )
        {
            System.out.println( "iElement:" + iElement.getName() + " '" + iElement.getTextContent() + "'" );

            // IElement yearElement = iElement.getElement( "//thead/tr/th[@colspan='3']");
            IElement yearElement = iElement.getElement( "//table/thead/tr/th[@colspan='3']" );
            System.out.println( "YearElement:" + yearElement.getTextContent() );

            List<IElement> tbodyElements = iElement.getElements( "//table[@class='year']/tbody" );
            for ( IElement itemTBody : tbodyElements )
            {
                System.out.println( "itemTBody: '" + itemTBody.getTextContent() + "'" );
            }
            // List<IElement> children = iElement.getChildren();
            // for ( IElement child : children )
            // {
            // System.out.println("Child: '" + child.getTextContent() + "'");
            // }
            // List<IElement> elements = iElement.getElements( "//tbody/tr/td[@class='date']");
            // for ( IElement iElement2 : elements )
            // {
            // System.out.println("X: '" + iElement2.getTextContent() + "'");
            // }
        }
    }
}
