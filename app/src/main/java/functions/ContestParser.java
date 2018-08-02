package functions;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.Contest;
import models.OnlineJudge;

/**
 * Created by saisumit on 5/23/15.
 */
public class ContestParser {

    public ArrayList<Contest> parse (String rssString) {
        ArrayList<Contest> contests = new ArrayList<>();

        Document doc = Jsoup.parseBodyFragment(rssString);

        if (doc.getElementsByTag("channel").size() == 0) {
            return contests;
        }
        Log.d("DEBUG","passed");
        Element channel = doc.getElementsByTag("channel").get(0);

        Elements contestsRSS = channel.getElementsByTag("item");

        for (Element contestRSS : contestsRSS) {

            Elements titleElements = contestRSS.getElementsByTag("title");
            Elements descriptionElements = contestRSS.getElementsByTag("description");
            Elements urlElements = contestRSS.getElementsByTag("url");
            Elements startDateElements = contestRSS.getElementsByTag("startTime");
            Elements endDateElements = contestRSS.getElementsByTag("endTime");

            String title ="",description = "",url = "",startDate = "" ,endDate = "";
            if (titleElements.size() != 0)
                title = titleElements.get(0).text();
            if (descriptionElements.size() != 0)
                description = descriptionElements.get(0).text();
            if (urlElements.size() != 0)
                url = urlElements.get(0).text();
            if (startDateElements.size() != 0)
                startDate = startDateElements.get(0).text();
            if (endDateElements.size() != 0)
                endDate = endDateElements.get(0).text();

            String source = getSourceFromTitleOrURL(title,url);

            Contest contest = (new Contest()).title(title).
                    description(description).
                    URL(url).
                    source(source).
                    startDate(getEpochFromDate(startDate)).
                    finishDate(getEpochFromDate(endDate));

            contests.add(contest);
        }

        return contests;
    }


    private static String getSourceFromTitleOrURL(String title,String url) {
        if (title.contains("Codeforces")) return OnlineJudge.CODEFORCES;
        else if (title.contains("Topcoder")) return OnlineJudge.TOPCODER;
        else if (title.contains("Codechef")) return OnlineJudge.CODECHEF;
        else if (title.contains("URIOJ")) return OnlineJudge.URIOJ;
        else if (title.contains("Hackerearth")) return OnlineJudge.HACKEREARTH;
        else {
            if (url.contains("hackerrank")) return OnlineJudge.HACKERRANK;
            else return OnlineJudge.UNKNOWN;
        }
    }

    private static Long getEpochFromDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        try {
            Date date = dateFormat.parse(dateString);
            return date.getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }
}
