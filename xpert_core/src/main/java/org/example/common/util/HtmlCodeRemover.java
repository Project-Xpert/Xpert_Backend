package org.example.common.util;

public class HtmlCodeRemover {

    public static String removeHtmlCode(String string) {
        return string
                .replaceAll("<b>", "")
                .replaceAll("</b>", "")
                .replaceAll("&[a-zA-Z]*;", "");
    }
}
