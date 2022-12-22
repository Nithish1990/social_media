package application.utilities;

import application.database.Database;
import application.video.Thumbnail;
import application.video.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchBar { // to be made as static
    private Database database;
    public List<Thumbnail> searchByName(String searchQuery){
        List<Thumbnail>searchResult = new ArrayList<>();
        for(Video video: database.getVideoBucket().values()){
            if(video.getVideoTitle().equals(searchQuery)){
                searchResult.add(video.getThumbnail());
            }
        }
        return searchResult;
    }
}
