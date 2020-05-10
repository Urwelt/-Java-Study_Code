package beans;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class WeatherNews {
	// 必要なEJB（WeatherFeedとMailSender）をインジェクトする
    @Inject
    WeatherFeed weather;
    private String tenki;

    public String getTenki() {
        return tenki;
    }

    public void setTenki(String tenki) {
        this.tenki = tenki;
    }
    
	// タイマーサービスを使って指定時間にメールを出すための@Scheduleアノテーションを追加する
    public String send() { // 自分あてに天気情報を送信する処理
        // ここにメール送信処理を書く
       this.tenki = weather.rss(13);
        return null;
    }
}
