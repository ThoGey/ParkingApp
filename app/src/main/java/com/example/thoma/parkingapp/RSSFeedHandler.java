package com.example.thoma.parkingapp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by thoma on 11/16/2015.
 */
public class RSSFeedHandler extends DefaultHandler{
    private RSSFeed feed;
    private RSSItem item;

    private boolean nameHasBeenRead = false;

    private boolean isName = false;
    private boolean isAddress = false;
    private boolean isContactInfo = false;

    public RSSFeed getFeed() {
        return feed;
    }

    @Override
    public void startDocument() throws SAXException {
        feed = new RSSFeed();
        item = new RSSItem();
    }

    @Override
    public void endDocument() throws SAXException { }

    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        if (qName.equals("element")) {
            item = new RSSItem();
            return;
        }
        else if (qName.equals("name")) {
            isName = true;
            return;
        }
        else if (qName.equals("address")) {
            isAddress = true;
            return;
        }
        else if (qName.equals("contactInfo")) {
            isContactInfo = true;
            return;
        }
    }


    @Override
    public void endElement(String namespaceURI, String localName,
                           String qName) throws SAXException
    {
        if (qName.equals("element")) {
            feed.addItem(item);
            return;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException
    {
        String s = new String(ch, start, length);
        if (isName) {
            if (nameHasBeenRead == false) {
                item.setName(s);
                nameHasBeenRead = true;
            }
            else {
                item.setName(s);
            }
            isName = false;
        }
        else if (isAddress) {
            item.setAddress(s);
            isAddress = false;
        }
        else if (isContactInfo) {
            item.setContactInfo(s);
            isContactInfo = false;
        }

    }

}
