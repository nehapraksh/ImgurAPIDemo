package com.nehaimgurdemoapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "description",
        "datetime",
        "cover",
        "cover_width",
        "cover_height",
        "account_url",
        "account_id",
        "privacy",
        "layout",
        "views",
        "link",
        "ups",
        "downs",
        "points",
        "score",
        "is_album",
        "vote",
        "favorite",
        "nsfw",
        "section",
        "comment_count",
        "favorite_count",
        "topic",
        "topic_id",
        "images_count",
        "in_gallery",
        "is_ad",
        "tags",
        "ad_type",
        "ad_url",
        "in_most_viral",
        "include_album_ads",
        "images",
        "ad_config",
        "type",
        "animated",
        "width",
        "height",
        "size",
        "bandwidth",
        "has_sound",
        "edited",
        "mp4",
        "gifv",
        "hls",
        "mp4_size",
        "looping",
        "processing"
})
public class Datum {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("datetime")
    private Integer datetime;
    @JsonProperty("cover")
    private String cover;
    @JsonProperty("cover_width")
    private Integer coverWidth;
    @JsonProperty("cover_height")
    private Integer coverHeight;
    @JsonProperty("account_url")
    private String accountUrl;
    @JsonProperty("account_id")
    private Integer accountId;
    @JsonProperty("privacy")
    private String privacy;
    @JsonProperty("layout")
    private String layout;
    @JsonProperty("views")
    private Integer views;
    @JsonProperty("link")
    private String link;
    @JsonProperty("ups")
    private Integer ups;
    @JsonProperty("downs")
    private Integer downs;
    @JsonProperty("points")
    private Integer points;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("is_album")
    private Boolean isAlbum;
    @JsonProperty("vote")
    private Object vote;
    @JsonProperty("favorite")
    private Boolean favorite;
    @JsonProperty("nsfw")
    private Boolean nsfw;
    @JsonProperty("section")
    private String section;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("topic_id")
    private Integer topic_id;
    @JsonProperty("images_count")
    private Integer images_count;
    @JsonProperty("in_gallery")
    private Boolean inGallery;
    @JsonProperty("is_ad")
    private Boolean isAd;
    @JsonProperty("tags")
    private List<Tag> tags = null;
    @JsonProperty("ad_type")
    private Integer adType;
    @JsonProperty("ad_url")
    private String adUrl;
    @JsonProperty("in_most_viral")
    private Boolean inMostViral;
    @JsonProperty("include_album_ads")
    private Boolean includeAlbumAds;
    @JsonProperty("images")
    private List<Image> images = new ArrayList<>();
    @JsonProperty("ad_config")
    private AdConfig adConfig;
    @JsonProperty("type")
    private String type;
    @JsonProperty("animated")
    private Boolean animated;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("bandwidth")
    private Double bandwidth;
    @JsonProperty("has_sound")
    private Boolean hasSound;
    @JsonProperty("edited")
    private Integer edited;
    @JsonProperty("mp4")
    private String mp4;
    @JsonProperty("gifv")
    private String gifv;
    @JsonProperty("hls")
    private String hls;
    @JsonProperty("mp4_size")
    private Integer mp4Size;
    @JsonProperty("looping")
    private Boolean looping;
    @JsonProperty("processing")
    private Processing processing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("datetime")
    public Integer getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(Integer datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("cover")
    public String getCover() {
        return cover;
    }

    @JsonProperty("cover")
    public void setCover(String cover) {
        this.cover = cover;
    }

    @JsonProperty("cover_width")
    public Integer getCoverWidth() {
        return coverWidth;
    }

    @JsonProperty("cover_width")
    public void setCoverWidth(Integer coverWidth) {
        this.coverWidth = coverWidth;
    }

    @JsonProperty("cover_height")
    public Integer getCoverHeight() {
        return coverHeight;
    }

    @JsonProperty("cover_height")
    public void setCoverHeight(Integer coverHeight) {
        this.coverHeight = coverHeight;
    }

    @JsonProperty("account_url")
    public String getAccountUrl() {
        return accountUrl;
    }

    @JsonProperty("account_url")
    public void setAccountUrl(String accountUrl) {
        this.accountUrl = accountUrl;
    }

    @JsonProperty("account_id")
    public Integer getAccountId() {
        return accountId;
    }

    @JsonProperty("account_id")
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("privacy")
    public String getPrivacy() {
        return privacy;
    }

    @JsonProperty("privacy")
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @JsonProperty("layout")
    public String getLayout() {
        return layout;
    }

    @JsonProperty("layout")
    public void setLayout(String layout) {
        this.layout = layout;
    }

    @JsonProperty("views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    @JsonProperty("ups")
    public Integer getUps() {
        return ups;
    }

    @JsonProperty("ups")
    public void setUps(Integer ups) {
        this.ups = ups;
    }

    @JsonProperty("downs")
    public Integer getDowns() {
        return downs;
    }

    @JsonProperty("downs")
    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    @JsonProperty("points")
    public Integer getPoints() {
        return points;
    }

    @JsonProperty("points")
    public void setPoints(Integer points) {
        this.points = points;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonProperty("is_album")
    public Boolean getIsAlbum() {
        return isAlbum;
    }

    @JsonProperty("is_album")
    public void setIsAlbum(Boolean isAlbum) {
        this.isAlbum = isAlbum;
    }

    @JsonProperty("vote")
    public Object getVote() {
        return vote;
    }

    @JsonProperty("vote")
    public void setVote(Object vote) {
        this.vote = vote;
    }

    @JsonProperty("favorite")
    public Boolean getFavorite() {
        return favorite;
    }

    @JsonProperty("favorite")
    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    @JsonProperty("nsfw")
    public Boolean getNsfw() {
        return nsfw;
    }

    @JsonProperty("nsfw")
    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("favorite_count")
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    @JsonProperty("favorite_count")
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @JsonProperty("topic_id")
    public Integer getTopicId() {
        return topic_id;
    }

    @JsonProperty("topic_id")
    public void setTopicId(Integer topicId) {
        this.topic_id = topicId;
    }

    @JsonProperty("images_count")
    public Integer getImagesCount() {
        return images_count;
    }

    @JsonProperty("images_count")
    public void setImagesCount(Integer imagesCount) {
        this.images_count = imagesCount;
    }

    @JsonProperty("in_gallery")
    public Boolean getInGallery() {
        return inGallery;
    }

    @JsonProperty("in_gallery")
    public void setInGallery(Boolean inGallery) {
        this.inGallery = inGallery;
    }

    @JsonProperty("is_ad")
    public Boolean getIsAd() {
        return isAd;
    }

    @JsonProperty("is_ad")
    public void setIsAd(Boolean isAd) {
        this.isAd = isAd;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @JsonProperty("ad_type")
    public Integer getAdType() {
        return adType;
    }

    @JsonProperty("ad_type")
    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    @JsonProperty("ad_url")
    public String getAdUrl() {
        return adUrl;
    }

    @JsonProperty("ad_url")
    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    @JsonProperty("in_most_viral")
    public Boolean getInMostViral() {
        return inMostViral;
    }

    @JsonProperty("in_most_viral")
    public void setInMostViral(Boolean inMostViral) {
        this.inMostViral = inMostViral;
    }

    @JsonProperty("include_album_ads")
    public Boolean getIncludeAlbumAds() {
        return includeAlbumAds;
    }

    @JsonProperty("include_album_ads")
    public void setIncludeAlbumAds(Boolean includeAlbumAds) {
        this.includeAlbumAds = includeAlbumAds;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("ad_config")
    public AdConfig getAdConfig() {
        return adConfig;
    }

    @JsonProperty("ad_config")
    public void setAdConfig(AdConfig adConfig) {
        this.adConfig = adConfig;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("animated")
    public Boolean getAnimated() {
        return animated;
    }

    @JsonProperty("animated")
    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("bandwidth")
    public Double getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(Double bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("has_sound")
    public Boolean getHasSound() {
        return hasSound;
    }

    @JsonProperty("has_sound")
    public void setHasSound(Boolean hasSound) {
        this.hasSound = hasSound;
    }

    @JsonProperty("edited")
    public Integer getEdited() {
        return edited;
    }

    @JsonProperty("edited")
    public void setEdited(Integer edited) {
        this.edited = edited;
    }

    @JsonProperty("mp4")
    public String getMp4() {
        return mp4;
    }

    @JsonProperty("mp4")
    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    @JsonProperty("gifv")
    public String getGifv() {
        return gifv;
    }

    @JsonProperty("gifv")
    public void setGifv(String gifv) {
        this.gifv = gifv;
    }

    @JsonProperty("hls")
    public String getHls() {
        return hls;
    }

    @JsonProperty("hls")
    public void setHls(String hls) {
        this.hls = hls;
    }

    @JsonProperty("mp4_size")
    public Integer getMp4Size() {
        return mp4Size;
    }

    @JsonProperty("mp4_size")
    public void setMp4Size(Integer mp4Size) {
        this.mp4Size = mp4Size;
    }

    @JsonProperty("looping")
    public Boolean getLooping() {
        return looping;
    }

    @JsonProperty("looping")
    public void setLooping(Boolean looping) {
        this.looping = looping;
    }

    @JsonProperty("processing")
    public Processing getProcessing() {
        return processing;
    }

    @JsonProperty("processing")
    public void setProcessing(Processing processing) {
        this.processing = processing;
    }

}