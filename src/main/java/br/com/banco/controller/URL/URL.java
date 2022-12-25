package br.com.banco.controller.URL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public Date convertDate(String textoDate){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = new Date();
        try {
           date = sdf.parse(textoDate);

        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }
}
