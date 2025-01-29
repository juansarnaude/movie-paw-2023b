package ar.edu.itba.paw.webapp.dto.out;

import ar.edu.itba.paw.models.MoovieList.MoovieListCard;
import ar.edu.itba.paw.models.Review.MoovieListReview;

import javax.persistence.Transient;
import javax.ws.rs.core.UriInfo;
import java.util.List;

public class MoovieListDto {

    private int id;

    private String name;

    private String createdBy;

    private String description;

    //TODO Considerar que capaz no hay que devolver esto
    private int type;

    private int likes;

    private int followers;

    private int mediaCount;

    private int movieCount;

    private List<MoovieListReview> reviews;

    private List<String> images;

    private String url;

    private String contentUrl;

    private String creatorUrl;

    private int currentUserWatchAmount;

    private boolean currentUserHasLiked;

    private boolean currentUserHasFollowed;


    public static MoovieListDto fromMoovieList(MoovieListCard moovieList, UriInfo uriInfo) {
        MoovieListDto dto = new MoovieListDto();
        dto.name = moovieList.getName();
        dto.createdBy = moovieList.getUsername();
        dto.id = moovieList.getMoovieListId();
        dto.name = moovieList.getName();
        dto.description = moovieList.getDescription();
        dto.type = moovieList.getType();
        dto.likes = moovieList.getLikeCount();
        dto.followers = moovieList.getFollowerCount();
        dto.mediaCount =  moovieList.getSize();
        dto.movieCount = moovieList.getMoviesAmount();
        dto.images =  moovieList.getImages();
        dto.url = uriInfo.getBaseUriBuilder().path("list/{moovieListId}").build(moovieList.getMoovieListId()).toString();
        dto.contentUrl = uriInfo.getBaseUriBuilder().path("list/{moovieListId}/content").build(moovieList.getMoovieListId()).toString();
        dto.creatorUrl = uriInfo.getBaseUriBuilder().path("users/username/{username}").build(moovieList.getUsername()).toString();
        dto.currentUserHasFollowed = moovieList.isCurrentUserHasLiked();
        dto.currentUserHasLiked = moovieList.isCurrentUserHasLiked();
        dto.currentUserWatchAmount = moovieList.getCurrentUserWatchAmount();
        return dto;
    }

    public static List<MoovieListDto> fromMoovieListList(List<MoovieListCard> mlcList, UriInfo uriInfo) {
        return mlcList.stream().map(mlc -> fromMoovieList(mlc, uriInfo)).collect(java.util.stream.Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getMediaCount() {
        return mediaCount;
    }

    public int getMovieCount() {
        return movieCount;
    }

    public void setMovieCount(int movieCount) {
        this.movieCount = movieCount;
    }

    public void setMediaCount(int mediaCount) {
        this.mediaCount = mediaCount;
    }

    public List<MoovieListReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<MoovieListReview> reviews) {
        this.reviews = reviews;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatorUrl() {
        return creatorUrl;
    }

    public void setCreatorUrl(String creatorUrl) {
        this.creatorUrl = creatorUrl;
    }

    public int getCurrentUserWatchAmount() {
        return currentUserWatchAmount;
    }

    public void setCurrentUserWatchAmount(int currentUserWatchAmount) {
        this.currentUserWatchAmount = currentUserWatchAmount;
    }

    public boolean isCurrentUserHasLiked() {
        return currentUserHasLiked;
    }

    public void setCurrentUserHasLiked(boolean currentUserHasLiked) {
        this.currentUserHasLiked = currentUserHasLiked;
    }

    public boolean isCurrentUserHasFollowed() {
        return currentUserHasFollowed;
    }

    public void setCurrentUserHasFollowed(boolean currentUserHasFollowed) {
        this.currentUserHasFollowed = currentUserHasFollowed;
    }
}
