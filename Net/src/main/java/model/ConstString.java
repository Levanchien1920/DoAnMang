/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author caoquangtrong
 */
public class ConstString {

    public static String header = "<!DOCTYPE html>\n"
            + "<html>\n"
            + "\n"
            + "<head>\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
            + "    <style>\n"
            + "        body {\n"
            + "            margin: 0 0px;\n"
            + "            padding: 0 10px;\n"
            + "        }\n"
            + "\n"
            + "        .container {\n"
            + "            border: 2px solid #dedede;\n"
            + "            background-color: #f1f1f1;\n"
            + "            border-radius: 10px;\n"
            + "            padding: 5px;\n"
            + "            margin: 5px 0;\n"
            + "        }\n"
            + "\n"
            + "        .darker {\n"
            + "            border: 2px solid #0e0c92;\n"
            + "            background-color: #f1f1f1;\n"
            + "            border-radius: 10px;\n"
            + "            padding: 5px;\n"
            + "            margin: 5px 0;\n"
            + "        }\n"
            + "        .content{\n"
            + "            font-size: 15pt;\n"
            + "        }\n"
            + "        .time{\n"
            + "            font-size: 10pt;\n"
            + "            font-style: italic;\n"
            + "            color: green;\n"
            + "        }\n"
            + "    </style>\n"
            + "</head>\n"
            + "\n"
            + "<body>";
    public static String footer = "</body>\n"
            + "\n"
            + "</html>";
    public static String dark = "darker";
    public static String light = "container";

    public static String MessageToString(Message me, Boolean check, String name) {
        String style = light;
        if (check == true) {
            style = dark;
        }
        String result = "<div class=\"" + style + "\">\n"
                + "        <div class=\"content\"><b>" + name + "</b>:" + me.getBody_msg() + "</div>\n"
                + "        <span class=\"time\">" + me.getDate_send() + "</span>\n"
                + "    </div>";
        return result;
    }
}
