package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "MyTeam";
        } else if ((query.contains("multiplied") ||
                query.contains("plus") ||
                query.contains("minus") ||
                query.contains("divided by")) && query.toLowerCase().startsWith("what is")) {
            String result = query.toLowerCase().replace("what", "").replace("is", "");
            int firstNumber = Integer.parseInt(result.split(" ")[0]);
            switch (result.split(" ")[1]){
                case "multiplied" -> {
                    return Integer.toString(firstNumber * Integer.parseInt(result.split(" ")[3]));
                }
                case "plus" -> {
                    return Integer.toString(firstNumber + Integer.parseInt(result.split(" ")[2]));
                }
                case "minus" -> {
                    return Integer.toString(firstNumber - Integer.parseInt(result.split(" ")[2]));

                }
                case "divided"-> {
                    return Integer.toString(firstNumber / Integer.parseInt(result.split(" ")[3]));
                }


            }

        }
        return "";
    }
}

