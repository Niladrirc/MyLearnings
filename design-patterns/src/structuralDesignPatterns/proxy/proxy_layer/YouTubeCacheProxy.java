package structuralDesignPatterns.proxy.proxy_layer;

import structuralDesignPatterns.proxy.some_cool_media_library.ThirdPartyYouTubeClass;
import structuralDesignPatterns.proxy.some_cool_media_library.ThirdPartyYouTubeLib;
import structuralDesignPatterns.proxy.some_cool_media_library.Video;

import java.util.HashMap;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> popularVideos = new HashMap<>();
    private HashMap<String, Video> allVideos = new HashMap<>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    @Override
    public HashMap<String, Video> popularVideos() {
        if (popularVideos.isEmpty()) {
            popularVideos = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return popularVideos;
    }

    @Override
    public Video getVideo(String videoId) {
        Video video = allVideos.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            allVideos.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    public void reset() {
        this.allVideos.clear();
        this.popularVideos.clear();
    }
}
