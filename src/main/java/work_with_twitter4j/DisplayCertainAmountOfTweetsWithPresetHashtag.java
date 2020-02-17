/*
Отобразить определённое количество твитов
с заданным хештегом
*/

package work_with_twitter4j;

class DisplayCertainAmountOfTweetsWithPresetHashtag extends BaseClass {

  public static void main(String[] args) throws twitter4j.TwitterException {
    final int amountOfTweets = 5;
    final String hashtag = "tomato";

    System.out.println("Количество твитов = " + amountOfTweets);
    System.out.println("Хештег = #" + hashtag);

    displayTweets(amountOfTweets, hashtag);
  }
}
