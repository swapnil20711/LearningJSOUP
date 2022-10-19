import org.jsoup.Jsoup

fun main() {
    val doc =
        Jsoup.connect("https://www.linkedin.com/posts/saheli-chatterjee-7b3023183_sales-tools-ugcPost-6987375370069032960-IxAG?utm_source=share&utm_medium=member_android")
    val element = doc.get().getElementById("main-content")
        ?.getElementsByClass("core-rail mx-auto papabear:w-core-rail-width mamabear:max-w-[790px] babybear:max-w-[790px]")!![0].allElements[1].getElementsByClass("share-native-video")?.first()
        ?.getElementsByClass("share-native-video__node video-js")?.attr("data-sources")
    println(element)
}