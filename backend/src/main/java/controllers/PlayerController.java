package controllers;

import domain.AudioFile;
import domain.HttpResponse;
import domain.exeptions.BaseException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Music player controller
 */
@RestController
public class PlayerController extends ControllerBase {
    //region Play controls
    /**
     * Toggle play/pause
     */
    @RequestMapping(value = "/play")
    public HttpResponse play() {
        this.playListProvider.togglePlay();
        return this.ok();
    }

    /**
     * Play next track
     */
    @RequestMapping(value = "/play/next")
    public HttpResponse next() {
        try {
            this.playListProvider.playNext();
            return this.ok();
        } catch (BaseException e) {
            return this.err(e);
        }
    }

    /**
     * Play previous track
     */
    @RequestMapping(value = "/play/previous")
    public HttpResponse previous() {
        try {
            this.playListProvider.playPrevious();
            return this.ok();
        } catch (BaseException e) {
            return this.err(e);
        }
    }

    /**
     * Set seek
     */
    @RequestMapping(value = "/play/seek")
    public HttpResponse seek(long millis) {
        this.playerProvider.audioPlayer().seek(millis);
        return this.ok();
    }
    //endregion

    //region Volume controls
    /**
     * Set volume
     */
    @RequestMapping(value = "/play/volume")
    public HttpResponse setVolume(double volume) {
        this.playerProvider.audioPlayer().volume(volume);
        return this.ok();
    }

    /**
     * Set volume
     */
    @RequestMapping(value = "/play/volume/increment")
    public HttpResponse volumeIncrement() {
        this.playerProvider.audioPlayer().volumeIncrement();
        return this.ok();
    }

    /**
     * Set volume
     */
    @RequestMapping(value = "/play/volume/decrement")
    public HttpResponse volumeDecrement() {
        this.playerProvider.audioPlayer().volumeDecrement();
        return this.ok();
    }
    //endregion

    //region Playlist controls
    /**
     * Set new playlist
     */
    @RequestMapping(value = "/playlist")
    public HttpResponse playlist(@RequestBody ArrayList<Integer> ids) {
        try {
            this.playListProvider.setPlaylist(ids);
            return this.ok("Ok");
        } catch (BaseException e) {
            return this.err(e);
        }
    }

    /**
     * Change playing file at playlist
     */
    @RequestMapping(value = "/playlist/selected")
    public HttpResponse playlistFile(int index) {
        try {
            this.playListProvider.playFile(index);
            return this.ok();
        } catch (BaseException e) {
            return this.err(e);
        }
    }
    //endregion
}
