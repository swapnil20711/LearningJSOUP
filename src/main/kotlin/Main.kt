import org.jsoup.Jsoup

fun main() {
    val doc =
        Jsoup.connect("https://www.linkedin.com/posts/saheli-chatterjee-7b3023183_sales-tools-ugcPost-6987375370069032960-IxAG?utm_source=share&utm_medium=member_android")
    val mainContent = doc.get().getElementById("main-content")
    val videoSrc = mainContent
        ?.getElementsByClass("core-rail mx-auto papabear:w-core-rail-width mamabear:max-w-[790px] babybear:max-w-[790px]")!![0].allElements[1].getElementsByClass(
        "share-native-video"
    )?.first()
        ?.getElementsByClass("share-native-video__node video-js")?.attr("data-sources")
    println(videoSrc?.split(",")?.first()?.removeRange(0, 8)?.removeSurrounding("\""))
    println(getLinkFromLinkedUrlOptimized("https://www.linkedin.com/posts/saheli-chatterjee-7b3023183_sales-tools-ugcPost-6987375370069032960-IxAG?utm_source=share&utm_medium=member_android"))
}

fun getLinkFromLinkedUrlOptimized(linkedInUrl: String): String? {
    val doc =
        Jsoup.connect(linkedInUrl)
    val mainContent = doc.get().getElementById("main-content")
    val videoSrc = mainContent?.firstElementChild()?.firstElementChild()?.select("video")?.attr("data-sources")
    return videoSrc?.split(",")?.first()?.removeRange(0, 8)?.removeSurrounding("\"")
}