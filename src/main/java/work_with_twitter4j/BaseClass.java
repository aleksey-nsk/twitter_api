package work_with_twitter4j;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.Date;
import static work_with_twitter4j.KeysAndTokens.*;

class BaseClass {

  // -----------------------------------------------
  // Конфигурация библиотеки Twitter4J
  // -----------------------------------------------
  protected static ConfigurationBuilder setConfiguration() {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey(CONSUMER_KEY);
    cb.setOAuthConsumerSecret(CONSUMER_SECRET);
    cb.setOAuthAccessToken(ACCESS_TOKEN);
    cb.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
    return cb;
  }

  // -----------------------------------------------
  // Создание объекта класса Twitter
  // -----------------------------------------------
  protected static Twitter createTwitter(ConfigurationBuilder cb) {
    TwitterFactory tf = new TwitterFactory(cb.build());
    Twitter twitter = tf.getInstance();
    return twitter;
  }

  // -----------------------------------------------
  // Отобразить определённое количество твитов
  // с заданным хештегом
  // -----------------------------------------------
  protected static void displayTweets(int amountOfTweets, String hashtag) throws TwitterException {
    // Объект класса Twitter:
    Twitter twitter = createTwitter(setConfiguration());

    // Запрос:
    Query query = new Query("%23" + hashtag); // %23 означает #
    query.setCount(amountOfTweets); // количество твитов
    Query.ResultType resultType = Query.ResultType.mixed;
    query.setResultType(resultType);
    query.setLang("en");
    System.out.println("query = " + query);

    // Результат запроса:
    QueryResult result = twitter.search(query);
    System.out.println("\n******************** Твиты: ********************");
    for (Status status : result.getTweets()) {
      String name = status.getUser().getScreenName();
      Date date = status.getCreatedAt();
      String text = status.getText();
      System.out.println("\n***** Tweet by @" + name + " [at " + date + "] :\n  " + text);
    }
  }
}
